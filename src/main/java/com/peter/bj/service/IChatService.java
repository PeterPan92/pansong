package com.peter.bj.service;

/**
 * @author panxinbing
 *         create time:  2018/4/27.
 */
public interface IChatService {

    /**
     *  调用图灵的问答接口，返回结果信息.
     * @param question 询问的问题
     * @return 返回问答结果
     */
    String getAskResult(String question);
}
