package com.mantis.lambda.pojo;

/**
 * @Description:结构不变的情况
 * @author: wei.wang
 * @since: 2020/6/16 15:06
 * @history: 1.2020/6/16 created by wei.wang
 */
public class OperateResult {

    /**
     * 返回状态码    SUCCESS/FAIL
     */
    private String returnCode;
    /**
     * 返回信息
     * 当return_code为FAIL时返回信息为错误原因  例如 ：签名失败
     */
    private String returnMsg;

    /**
     * 当return_code为SUCCESS的时候存在
     */

    /**
     * 业务结果 	SUCCESS/FAIL
     */
    private String resultCode;
    /**
     * 错误代码
     */
    private String errCode;
    /**
     * 错误代码描述
     */
    private String errCodeDes;

    /**
     * 当return_code 和result_code都为SUCCESS的时存在
     */
    /**
     * 订单号
     */
    private String outTradeNo;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public void setErrCodeDes(String errCodeDes) {
        this.errCodeDes = errCodeDes;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Override
    public String toString() {
        return "OperateResult{" +
                "returnCode='" + returnCode + '\'' +
                ", returnMsg='" + returnMsg + '\'' +
                ", resultcode='" + resultCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errCodeDes='" + errCodeDes + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                '}';
    }
}
