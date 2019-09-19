package com.system.controller;

import com.system.entity.TRecord;
import com.system.pojo.record.RecordVo;
import com.system.service.record.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.system.utils.R;

import java.util.List;

/**
 * @author pengyu
 * @Date 2019/6/21
 * @Description
 */
@RestController
@RequestMapping("/biz/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping("")
    public R recordAdd(@RequestBody TRecord record){
        try {
            recordService.recordAdd(record);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    /**
     * 添加考试成绩记录
     * @param recordVo
     * @return
     */
    @PostMapping("/recordVo")
    public R recordVoAdd(@RequestBody RecordVo recordVo){
        try {
            TRecord record = recordService.recordVoAdd(recordVo);
            return R.ok(record);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @GetMapping("/recordVo/{examineeId}/{examId}")
    public R findRecordVo(@PathVariable Integer examineeId,@PathVariable Integer examId){
        try {
            RecordVo recordVo = recordService.getRecordVo(examineeId, examId);
            return R.ok(recordVo);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }


    @GetMapping("/{examineeId}/{examId}")
    public R findRecord( @PathVariable Integer examineeId,@PathVariable Integer examId){
        try {
            List<TRecord> records = recordService.findRecords(examineeId, examId);
            return R.ok(records);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

    @GetMapping("/{recordId}")
    public R findRecord( @PathVariable Integer recordId){
        try {
            TRecord records = recordService.findRecords(recordId);
            return R.ok(records);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }

}
