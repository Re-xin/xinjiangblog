package com.xinjiang.blog.service;

import com.xinjiang.blog.po.Message;

import java.util.List;

/**
 * @author 陈智彬 Re新酱
 * @date 2020/6/19 16:09
 * @description:
 */
public interface MessageService {
    //查询留言列表
    List<Message> listMessage();

    //保存留言
    int saveMessage(Message message);

    //删除留言
    void deleteMessage(Long id);
}
