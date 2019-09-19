package com.system.controller.wor;

import com.system.pojo.wor.SubInOpts;
import com.system.service.wor.WorService;
import com.system.utils.R;
import com.system.utils.ReqPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biz/wor")
@Api(value = "WorController接口")
public class WorController {

    @Autowired
    private WorService worService;

    /**
     * 查试题列表
     *
     * @param page
     * @param subjectMode       0.交通法规, 1.民法知识 2.刑法知识 3.趣味知识 4.其他知识(可关联字典表)
     * @param subjectDifficulty 0.简单 ,1.一般 2.困难
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(value = "试题列表", notes = "根据条件查试题列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "pageNum", value = "当前页码  默认1",paramType="query",dataType = "int"),
//            @ApiImplicitParam(name = "limit", value = "页面大小  默认10",paramType="query",dataType = "int"),
//            @ApiImplicitParam(name = "搜索关键字", value = "搜索关键字",paramType="query",dataType = "String"),
//            @ApiImplicitParam(name = "subjectMode", value = "试题类型 0.交通法规, 1.民法知识 2.刑法知识 3.趣味知识 4.其他知识(可关联字典表)",paramType="query",dataType = "int"),
//            @ApiImplicitParam(name = "subjectDifficulty", value = "试题难度 0.简单 ,1.一般 2.困难",paramType="query",dataType = "int")
//    })
    @ApiResponse(message = "反正我是返回了", code = 200, response = R.class)
//    public R list(@ApiParam(value = "分页 pageNum limit") ReqPage.QReqPage page,
    public R list(@ModelAttribute ReqPage.QReqPage page,
                  @ApiParam(value = "试题类型 0.交通法规, 1.民法知识 2.刑法知识 3.趣味知识 4.其他知识(可关联字典表)") @RequestParam(required = false) Integer subjectMode,
                  @ApiParam(value = "试题难度 0.简单 ,1.一般 2.困难") @RequestParam(required = false) Integer subjectDifficulty) {
        try {
            return R.ok(worService.list(page, subjectMode, subjectDifficulty));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }


    /**
     * 查试题详情
     *
     * @param subjectId 题库id
     * @return
     */
    @GetMapping("/detail/{subjectId}")
    public R detail(@PathVariable Integer subjectId) {
        try {
            return R.ok(worService.detail(subjectId));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }


    /**
     * 删除题库和选项
     *
     * @param subjectIds
     * @param isdelOpts  是否删除题库选项
     * @return
     */
    @DeleteMapping("/batch")
    public R batchRemove(@RequestParam(value = "subjectIds") int[] subjectIds, @RequestParam(required = false, defaultValue = "true") boolean isdelOpts) {
        try {
            return worService.batchDelSubsAndOptsBySubIds(subjectIds, isdelOpts) ? R.ok() : R.error();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    /**
     * 查选项
     *
     * @param subjectId
     * @return
     */
    @GetMapping("/{subjectId}")
    public R optsBySId(@PathVariable int subjectId) {
        try {
            return R.ok(worService.findOptsBySId(subjectId));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }


    /**
     * 保存题库
     *
     * @param subInOpts
     * @return
     */
    @PostMapping("/orOpts")
    public R savesOrOpts(@RequestBody List<SubInOpts> subInOpts) {
        try {
            return R.ok(worService.savesOrOpts(subInOpts));
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }
}
