package com.whdx.data.net.exception


class ResultException(var errCode: String?, var msg: String?) : Exception(msg)
