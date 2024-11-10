package com.devx.kdeviceinfo.model.desktop.operatingsystem.protocols

enum class TcpState {
    UNKNOWN, CLOSED, LISTEN, SYN_SENT, SYN_RECV, ESTABLISHED, FIN_WAIT_1, FIN_WAIT_2, CLOSE_WAIT, CLOSING, LAST_ACK,
    TIME_WAIT, NONE
}