/*
 *-----------------------------------------------------------------------------
 * Copyright 2018 NCR Corporation
 *-----------------------------------------------------------------------------
 */
package com.queue;

/**
 *
 * @author lv250077 Simple Message class to put and get message into queue
 */
public class CrunchifyMessage {
    private final String crunchifyMsg;

    public CrunchifyMessage(final String string) {
        crunchifyMsg = string;
    }

    public String getMsg() {
        return crunchifyMsg;
    }
}
