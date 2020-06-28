package com.wyjie.mall.product.exception;

import com.wyjie.common.exception.BizCodeEnume;
import com.wyjie.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther wyjie
 * @date 2020/6/25 - 周四
 */

/**
 * 集中处理所有异常
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.wyjie.mall.product.controller")
public class MallExceptionControllerAdvice {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型：{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        bindingResult.getFieldErrors().forEach((item) -> {
            map.put(item.getField(), item.getDefaultMessage());
        });
        return R.error(BizCodeEnume.VALID_EXCEPTION.getCode(), BizCodeEnume.VALID_EXCEPTION.getMessage()).put("data", map);
    }
    
    @ExceptionHandler(value = {Throwable.class})
    public R handleException(Throwable t) {
        log.error(t.getMessage());
        log.error(t.getLocalizedMessage());
        log.error(t.getCause().getMessage());
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(),
                BizCodeEnume.UNKNOW_EXCEPTION.getMessage());
    }
}
