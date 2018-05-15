package part07

import java.util.*

/**
 * Calendar
 */
fun main(args: Array<String>) {

    val calendar = Calendar.getInstance()

    println(calendar)
    /*
    java.util.GregorianCalendar[
    time=1525570916355,
    areFieldsSet=true,
    areAllFieldsSet=true,
    lenient=true,
    zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",
    offset=28800000,
    dstSavings=0,
    useDaylight=false,
    transitions=19,
    lastRule=null],
    firstDayOfWeek=1,
    minimalDaysInFirstWeek=1,
    ERA=1,
    YEAR=2018,
    MONTH=4,
    WEEK_OF_YEAR=19,
    WEEK_OF_MONTH=2,
    DAY_OF_MONTH=6,
    DAY_OF_YEAR=126,
    DAY_OF_WEEK=1,
    DAY_OF_WEEK_IN_MONTH=1,
    AM_PM=0,
    HOUR=9,
    HOUR_OF_DAY=9,
    MINUTE=41,
    SECOND=56,
    MILLISECOND=355,
    ZONE_OFFSET=28800000,
    DST_OFFSET=0]
     */

    //查表法
    val months = arrayOf("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月")
    val weeks = arrayOf("", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")

    //设置指定时间
    //calendar.set(2018,4,5)

    //移动指定字段（年、月、日）前移或后退
    //calendar.add(Calendar.YEAR,1)//往后推一年，如2018往后推一年是2019
    //calendar.add(Calendar.MONTH,1)//往后推一月，如5月往后推一月是6月
    //calendar.add(Calendar.DAY_OF_MONTH,-1)//往前推1天，如6号往前推一天是5号

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val week = calendar.get(Calendar.DAY_OF_WEEK)
    println(year)
    println(months[month])
    println(day)
    println(weeks[week])

}