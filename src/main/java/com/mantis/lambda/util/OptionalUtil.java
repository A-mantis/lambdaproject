package com.mantis.lambda.util;

import com.mantis.lambda.exception.BusinessException;
import com.mantis.lambda.pojo.Car;
import com.mantis.lambda.pojo.Insurance;
import com.mantis.lambda.pojo.OperateResult;
import com.mantis.lambda.pojo.Person;

import java.util.Optional;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/6/16 15:03
 * @history: 1.2020/6/16 created by wei.wang
 */
public class OptionalUtil {

    public static void main(String[] args) {
        //valid1();
        //valid2();
        //valid3();
        //valid4();
        //valid5();

        Person person = new Person();
        Car car = new Car();
        Insurance insurance = new Insurance();
        insurance.setName("");
        car.setInsurance(insurance);
        person.setCar(car);
        System.out.println(person);
        System.out.println(optionalGetCarInsuranceName(person));
        //test();
    }

    /**
     * 正常返回
     */
    private static void valid1() {
        OperateResult operateResult = new OperateResult();
        operateResult.setReturnCode("SUCCESS");
        operateResult.setReturnMsg("OK");
        operateResult.setResultCode("SUCCESS");
        operateResult.setErrCode("");
        operateResult.setErrCodeDes("");
        operateResult.setOutTradeNo("20200616151602SDCFV7JHEFOEUGH083WEIGH9");
        valid(operateResult);
    }

    /**
     * 状态码失败
     */
    private static void valid2() {
        OperateResult operateResult = new OperateResult();
        operateResult.setReturnCode("FAIL");
        operateResult.setReturnMsg("签名失败");
        valid(operateResult);

    }

    /**
     * 业务结果失败
     */
    private static void valid3() {
        OperateResult operateResult = new OperateResult();
        operateResult.setReturnCode("SUCCESS");
        operateResult.setReturnMsg("OK");
        operateResult.setResultCode("FAIL");
        operateResult.setErrCode("NOTENOUGH");
        operateResult.setErrCodeDes("余额不足");
        valid(operateResult);
    }

    /**
     * 订单号异常
     */
    private static void valid4() {
        OperateResult operateResult = new OperateResult();
        operateResult.setReturnCode("SUCCESS");
        operateResult.setReturnMsg("OK");
        operateResult.setResultCode("SUCCESS");
        operateResult.setErrCode("");
        operateResult.setErrCodeDes("");
        //operateResult.setOutTradeNo("");
        valid(operateResult);
    }

    /**
     * 其他失败
     */
    private static void valid5() {
//        OperateResult operateResult1 = new OperateResult();
//        valid(operateResult1);

        OperateResult operateResult2 = new OperateResult();
        operateResult2.setReturnCode("SUCCESS");
        operateResult2.setReturnMsg("OK");
        operateResult2.setErrCode("");
        operateResult2.setErrCodeDes("");
        operateResult2.setOutTradeNo("20200616151602SDCFV7JHEFOEUGH083WEIGH9");
        valid(operateResult2);

        OperateResult operateResult3 = new OperateResult();
        operateResult3.setResultCode("SUCCESS");
        operateResult3.setErrCode("");
        operateResult3.setErrCodeDes("");
        operateResult3.setOutTradeNo("20200616151602SDCFV7JHEFOEUGH083WEIGH9");
        valid(operateResult3);

        OperateResult operateResult4 = new OperateResult();
        operateResult4.setReturnCode("SUCCESS");
        operateResult4.setOutTradeNo("20200616151602SDCFV7JHEFOEUGH083WEIGH9");
        valid(operateResult4);
    }


    private static void test() {
        OperateResult operateResult = new OperateResult();
        operateResult.setReturnCode("SUCCESSA");
        operateResult.setReturnMsg("OK");
        operateResult.setResultCode("SUCCESS");
        operateResult.setErrCode("");
        operateResult.setErrCodeDes("");
        operateResult.setOutTradeNo("");
        String outTradeNo =
                Optional.ofNullable(operateResult)
                        .filter(OptionalUtil::returnCodeSuccess)
                        .filter(OptionalUtil::resultCodeSuccess)
                        .map(OperateResult::getOutTradeNo)
                        .filter(DataUtil::isStrNull)
                        .orElseThrow(() -> new BusinessException("获取到的订单号为空"));
        System.out.println(outTradeNo);
    }

    /**
     * 不使用Optional
     * @param p
     * @return
     */
    private static String normalGetCarInsuranceName(Person p) {
        if (p == null) {
            return "Unknown";
        }
        Car car = p.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }

    /**
     * 使用Optional
     * 关于Optional，官方说，判断有优势，处理逻辑明确
     * @param p
     * @return
     */
    private static String optionalGetCarInsuranceName(Person p) {
        return Optional.of(p)
                .map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .filter(DataUtil::isStrNull)
                .orElse("unknown");
    }

    /**
     * 使用Optional
     *
     * @param operateResult
     */
    private static void valid(OperateResult operateResult) {
        Optional.ofNullable(operateResult)
                .orElseThrow(() -> new BusinessException("操作结果为空"));
        Optional.of(operateResult)
                .filter(OptionalUtil::returnCodeSuccess)
                .orElseThrow(() -> new BusinessException(DataUtil.isStrEmpty(operateResult.getReturnMsg()) ? "系统错误" : operateResult.getReturnMsg()));
        Optional.of(operateResult)
                .filter(OptionalUtil::resultCodeSuccess)
                .orElseThrow(() -> new BusinessException(DataUtil.isStrEmpty(operateResult.getErrCodeDes()) ? "与服务器通讯失败" : operateResult.getErrCodeDes()));
        Optional.of(operateResult)
                .filter(o -> DataUtil.isStrNull(o.getOutTradeNo()))
                .orElseThrow(() -> new BusinessException("获取到的订单号为空"));
    }

    /**
     * 校验返回结果
     *
     * @param operateResult
     * @return
     */
    private static boolean returnCodeSuccess(OperateResult operateResult) {
        return "SUCCESS".equals(operateResult.getReturnCode());
    }


    /**
     * 校验业务结果
     *
     * @param operateResult
     * @return
     */
    private static boolean resultCodeSuccess(OperateResult operateResult) {
        return "SUCCESS".equals(operateResult.getResultCode());
    }


    /**
     * 不使用Optional
     *
     * @param operateResult
     */
    public void normalValid(OperateResult operateResult) {
        if (operateResult == null) {
            throw new BusinessException("操作结果为空");
        }
        if (!returnCodeSuccess(operateResult)) {
            throw new BusinessException(DataUtil.isStrEmpty(operateResult.getReturnMsg()) ? "系统错误" : operateResult.getReturnMsg());
        }
        if (!resultCodeSuccess(operateResult)) {
            throw new BusinessException(DataUtil.isStrEmpty(operateResult.getErrCodeDes()) ? "与服务器通讯失败" : operateResult.getErrCodeDes());
        }
        if (DataUtil.isStrEmpty(operateResult.getOutTradeNo())) {
            throw new BusinessException("获取到的订单号为空");
        }
    }





}
