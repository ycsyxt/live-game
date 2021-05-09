package com.ycsyxt.controller;

import com.ycsyxt.util.LifeGameUtil;
import com.ycsyxt.vo.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuxt
 * @date 2021/5/9
 * 1 初始化：棋盘大小row和col,存活行下标数组liveArray
 * 2 根据规则模拟演化
 * 3 返回结果
 */
@RestController
@RequestMapping("/liveGame")
public class LifeGameController {

    @GetMapping("/init")
    public AjaxResult initBoard(int row, int col, int[] liveArray) {
        int[][] board = LifeGameUtil.init(row, col, liveArray);
        return AjaxResult.success(board);
    }

    @GetMapping("/next")
    public AjaxResult nextBoard() {
        int[][] board = LifeGameUtil.next();
        return AjaxResult.success(board);
    }
}

