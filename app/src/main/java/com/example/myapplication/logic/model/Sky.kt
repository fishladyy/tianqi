package com.example.myapplication.logic.model

import com.example.myapplication.R

class Sky (val info: String, val icon: Int, val bg: Int)
private val sky = mapOf(
    "CLEAR_DAY" to Sky("晴", R.drawable.qing, R.drawable.qing),
    "CLEAR_NIGHT" to Sky("晴", R.drawable.qing, R.drawable.qing),
    "PARTLY_CLOUDY_DAY" to Sky("多云", R.drawable.nongyun,
        R.drawable.nongyun),
    "PARTLY_CLOUDY_NIGHT" to Sky("多云", R.drawable.nongyun,
        R.drawable.nongyun),
    "CLOUDY" to Sky("阴", R.drawable.yin, R.drawable.yin),
    "WIND" to Sky("大风", R.drawable.dafeng, R.drawable.dafeng),
    "LIGHT_RAIN" to Sky("小雨", R.drawable.xiaoyu ,R.drawable.xiaoyu),
    "MODERATE_RAIN" to Sky("中雨", R.drawable.zhongyu, R.drawable.zhongyu),
    "HEAVY_RAIN" to Sky("大雨", R.drawable.dayu, R.drawable.dayu),
    "STORM_RAIN" to Sky("暴雨", R.drawable.baoyu, R.drawable.baoyu),
    "THUNDER_SHOWER" to Sky("雷阵雨", R.drawable.leizhenyu, R.drawable.leizhenyu),
    "SLEET" to Sky("雨夹雪", R.drawable.yujiaxue, R.drawable.yujiaxue),
    "LIGHT_SNOW" to Sky("小雪", R.drawable.xiaoxue, R.drawable.xiaoxue),
    "MODERATE_SNOW" to Sky("中雪", R.drawable.zhongxue, R.drawable.zhongxue),
    "HEAVY_SNOW" to Sky("大雪", R.drawable.daxue, R.drawable.daxue),
    "STORM_SNOW" to Sky("暴雪", R.drawable.baoxue, R.drawable.baoxue),
    "HAIL" to Sky("冰雹", R.drawable.bingbao, R.drawable.bingbao),
    "LIGHT_HAZE" to Sky("轻度雾霾", R.drawable.qingduwumai, R.drawable.qingduwumai),
    "MODERATE_HAZE" to Sky("中度雾霾", R.drawable.zhongduwumai, R.drawable.zhongduwumai),
    "HEAVY_HAZE" to Sky("重度雾霾", R.drawable.zhongduwumai_1, R.drawable.zhongduwumai_1),
    "FOG" to Sky("雾", R.drawable.wuqi, R.drawable.wuqi),
    "DUST" to Sky("浮尘", R.drawable.fuchen, R.drawable.fuchen                                 )
)
fun getSky(skycon: String): Sky {
    return sky[skycon] ?: sky["CLEAR_DAY"]!!
}