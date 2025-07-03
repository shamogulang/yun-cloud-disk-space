package com.example.cloudspace.controller;

import com.example.cloudspace.entity.Space;
import com.example.cloudspace.service.SpaceService;
import com.example.cloudspace.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/space")
public class SpaceController {
    @Autowired
    private SpaceService spaceService;

    @PostMapping("/create")
    public Result<Integer> createSpace(@RequestParam Long userId, @RequestParam Long size) {
        Space space = new Space();
        space.setUserId(userId);
        space.setTotalSpace(size);
        space.setUsedSpace(0L);
        return Result.success(spaceService.createSpace(space));
    }

    @PostMapping("/update")
    public Result<Integer> updateSpace(@RequestBody Space space) {
        return Result.success(spaceService.updateSpace(space));
    }

    @PostMapping("/delete")
    public Result<Integer> deleteSpace(@RequestBody IdRequest req) {
        return Result.success(spaceService.deleteSpace(req.getId()));
    }

    @PostMapping("/getById")
    public Result<Space> getSpaceById(@RequestBody IdRequest req) {
        return Result.success(spaceService.getSpaceById(req.getId()));
    }

    @PostMapping("/getByUserId")
    public Result<List<Space>> getSpacesByUserId(@RequestBody UserIdRequest req) {
        return Result.success(spaceService.getSpacesByUserId(req.getUserId()));
    }

    @PostMapping("/statistics")
    public Result<TotalStatistics> getTotalStatistics(@RequestAttribute("userId") Long userId) {
        List<Space> spaces = spaceService.getSpacesByUserId(userId); // 获取所有空间
        long totalSpace = 0L;
        long usedSpace = 0L;
        for (Space s : spaces) {
            totalSpace += s.getTotalSpace() == null ? 0 : s.getTotalSpace();
            usedSpace += s.getUsedSpace() == null ? 0 : s.getUsedSpace();
        }
        TotalStatistics stat = new TotalStatistics();
        stat.setTotalSpace(totalSpace);
        stat.setUsedSpace(usedSpace);
        return Result.success(stat);
    }

    // 内部请求对象
    public static class IdRequest {
        private Long id;
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
    }
    public static class UserIdRequest {
        private Long userId;
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
    }

    public static class TotalStatistics {
        private Long totalSpace;
        private Long usedSpace;
        public Long getTotalSpace() { return totalSpace; }
        public void setTotalSpace(Long totalSpace) { this.totalSpace = totalSpace; }
        public Long getUsedSpace() { return usedSpace; }
        public void setUsedSpace(Long usedSpace) { this.usedSpace = usedSpace; }
    }
} 