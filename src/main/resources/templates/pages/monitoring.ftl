<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>健康监控</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="/images/favicon.png">
    <!-- Custom Stylesheet -->
    <link href="/vendor/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">

</head>

<body>

<!--*******************
    Preloader start
********************-->
<div id="preloader">
    <div class="sk-three-bounce">
        <div class="sk-child sk-bounce1"></div>
        <div class="sk-child sk-bounce2"></div>
        <div class="sk-child sk-bounce3"></div>
    </div>
</div>
<!--*******************
    Preloader end
********************-->


<!--**********************************
    Main wrapper start
***********************************-->
<div id="main-wrapper">

    <!--**********************************
        Nav header start
    ***********************************-->
    <div class="nav-header">
        <a href="index.html" class="brand-logo">
            <img class="logo-abbr" src="/images/logo.png" alt="">
            <img class="logo-compact" src="/images/logo-text.png" alt="">
            <img class="brand-title" src="/images/logo-text.png" alt="">
        </a>

        <div class="nav-control">
            <div class="hamburger">
                <span class="line"></span><span class="line"></span><span class="line"></span>
            </div>
        </div>
    </div>
    <!--**********************************
        Nav header end
    ***********************************-->

    <!--**********************************
        Chat box start
    ***********************************-->
    <!--**********************************
        Chat box End
    ***********************************-->




    <!--**********************************
        Header start
    ***********************************-->
    <div class="header">
        <div class="header-content">
            <nav class="navbar navbar-expand">
                <div class="collapse navbar-collapse justify-content-between">
                    <div class="header-left">
                        <div class="dashboard_bar">
                            健康监控
                        </div>
                    </div>

                    <ul class="navbar-nav header-right">
                        <li class="nav-item dropdown notification_dropdown">
                            <a class="nav-link dz-fullscreen" href="#">
                                <svg id="icon-full" viewBox="0 0 24 24" width="26" height="26" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><path d="M8 3H5a2 2 0 0 0-2 2v3m18 0V5a2 2 0 0 0-2-2h-3m0 18h3a2 2 0 0 0 2-2v-3M3 16v3a2 2 0 0 0 2 2h3"></path></svg>
                                <svg id="icon-minimize" width="26" height="26" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-minimize"><path d="M8 3v3a2 2 0 0 1-2 2H3m18 0h-3a2 2 0 0 1-2-2V3m0 18v-3a2 2 0 0 1 2-2h3M3 16h3a2 2 0 0 1 2 2v3"></path></svg>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
    <!--**********************************
        Header end ti-comment-alt
    ***********************************-->

    <!--**********************************
        Sidebar start
    ***********************************-->
    <div class="deznav">
        <div class="deznav-scroll">
            <ul class="metismenu" id="menu">
                <li>
                    <a class="has-arrow ai-icon" href="javascript:void()" aria-expanded="false">
                      <i class="flaticon-381-network"></i>
                      <span class="nav-text">运行信息</span>
                    </a>
                    <ul aria-expanded="false">
                        <#list menus as menu>
                            <li><a href="/monitoring/${menu.hrefA}/${menu.hrefH}">${menu.name}</a></li>
                        </#list>
                    </ul>
                </li>
            </ul>

            <div class="plus-box">
                <p>Health</p>
            </div>
            <#--<div class="copyright">
                <p><strong>Application Health</strong> © 2020 All Rights Reserved</p>
                <p>Made with <i class="fa fa-heart"></i> by bkzy</p>
            </div>-->
        </div>
    </div>
    <!--**********************************
        Sidebar end
    ***********************************-->

    <!--**********************************
        Content body start
    ***********************************-->
    <div class="content-body">
        <div class="container-fluid">
            <div class="row page-titles mx-0">
                  <div class="col-sm-6 p-md-0">
                    <div class="welcome-text">
                        <h4>监控采集系统程序地址：${hrefA!}</h4>
                    </div>
                </div>
                <div class="col-sm-6 p-md-0">
                    <div class="welcome-text">
                        <h4>健康监控程序地址：${hrefH!}</h4>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">监控程序配置信息</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-info">
                                    <tr>
                                        <th>参数</th>
                                        <th>描述</th>
                                        <th>当前值</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>
                                            <a-tag color="green">startInterva</a-tag>
                                        </td>
                                        <td>重启时间间隔</td>
                                        <td><span ></span> 秒</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="green">period</a-tag>
                                        </td>
                                        <td>循环周期</td>
                                        <td><span ></span> 秒</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">FLAG</a-tag>
                                        </td>
                                        <td>开启开关</td>
                                        <td><span ></span></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">JVMSIZE</a-tag>
                                        </td>
                                        <td>设置的JVM总大小</td>
                                        <td><span ></span> 字节</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">CAST</a-tag>
                                        </td>
                                        <td>已使用JVM峰值占比(超出后重启)</td>
                                        <td><span></span> %</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">CASTCPU</a-tag>
                                        </td>
                                        <td>已使用CPU峰值占比(超出后重启)</td>
                                        <td><span></span> MB</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">CMDPATH</a-tag>
                                        </td>
                                        <td>重启bat路径</td>
                                        <td><span id=""></span></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">运行信息</h4>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead class="thead-info">
                                    <tr>
                                        <th>参数</th>
                                        <th>描述</th>
                                        <th>当前值</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>
                                            <a-tag color="green">system.cpu.count</a-tag>
                                        </td>
                                        <td>CPU 数量</td>
                                        <td><span id="system-cpu-count"></span> 核</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="green">system.cpu.usage</a-tag>
                                        </td>
                                        <td>系统 CPU 使用率</td>
                                        <td><span id="system-cpu-usage"></span> %</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">process.start.time</a-tag>
                                        </td>
                                        <td>应用启动时间点</td>
                                        <td><span id="process-start-time"></span></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">process.uptime</a-tag>
                                        </td>
                                        <td>应用已运行时间</td>
                                        <td><span id="process-uptime"></span> 秒</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">process.cpu.usage</a-tag>
                                        </td>
                                        <td>当前应用 CPU 使用率</td>
                                        <td><span id="process-cpu-usage"></span> %</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">jvm.memory.max</a-tag>
                                        </td>
                                        <td>JVM 最大内存</td>
                                        <td><span id="jvm-memory-max"></span> MB</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">jvm.memory.committed</a-tag>
                                        </td>
                                        <td>JVM 可用内存</td>
                                        <td><span id="jvm-memory-committed"></span> MB</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="purple">jvm.memory.used</a-tag>
                                        </td>
                                        <td>JVM 已用内存</td>
                                        <td><span id="jvm-memory-used"></span> MB</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="cyan">jvm.buffer.memory.used</a-tag>
                                        </td>
                                        <td>JVM 缓冲区已用内存</td>
                                        <td><span id="jvm-buffer-memory-used"></span> MB</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="cyan">jvm.buffer.count</a-tag>
                                        </td>
                                        <td>当前缓冲区数量</td>
                                        <td><span id="jvm-buffer-count"></span> 个</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="green">jvm.threads.daemon</a-tag>
                                        </td>
                                        <td>JVM 守护线程数量</td>
                                        <td><span id="jvm-threads-daemon"></span> 个</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="green">jvm.threads.live</a-tag>
                                        </td>
                                        <td>JVM 当前活跃线程数量</td>
                                        <td><span id="jvm-threads-live"></span> 个</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="green">jvm.threads.peak</a-tag>
                                        </td>
                                        <td>JVM 峰值线程数量</td>
                                        <td><span id="jvm-threads-peak"></span> 个</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="orange">jvm.classes.loaded</a-tag>
                                        </td>
                                        <td>JVM 已加载 Class 数量</td>
                                        <td><span id="jvm-classes-loaded"></span> 个</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="orange">jvm.classes.unloaded</a-tag>
                                        </td>
                                        <td>JVM 未加载 Class 数量</td>
                                        <td><span id="jvm-classes-unloaded"></span> 个</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="pink">jvm.gc.memory.allocated</a-tag>
                                        </td>
                                        <td>GC 时, 年轻代分配的内存空间</td>
                                        <td><span id="jvm-gc-memory-allocated"></span> MB</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="pink">jvm.gc.memory.promoted</a-tag>
                                        </td>
                                        <td>GC 时, 老年代分配的内存空间</td>
                                        <td><span id="jvm-gc-memory-promoted"></span> MB</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="pink">jvm.gc.max.data.size</a-tag>
                                        </td>
                                        <td>GC 时, 老年代的最大内存空间</td>
                                        <td><span id="jvm-gc-max-data-size"></span> MB</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="pink">jvm.gc.live.data.size</a-tag>
                                        </td>
                                        <td>FullGC 时, 老年代的内存空间</td>
                                        <td><span id="jvm-gc-live-data-size"></span> MB</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="blue">jvm.gc.pause.count</a-tag>
                                        </td>
                                        <td>系统启动以来GC 次数</td>
                                        <td><span id="jvm-gc-pause-count"></span> 次</td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <a-tag color="blue">jvm.gc.pause.totalTime</a-tag>
                                        </td>
                                        <td>系统启动以来GC 总耗时</td>
                                        <td><span id="jvm-gc-pause-total-time"></span> 秒</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--**********************************
        Content body end
    ***********************************-->


    <!--**********************************
        Footer start
    ***********************************-->
    <div class="footer">
        <div class="copyright">
            <p>Copyright © Designed &amp; Developed by <a href="" target="_blank">北矿智云科技（北京）有限公司</a> 2020</p>
        </div>
    </div>
    <!--**********************************
        Footer end
    ***********************************-->

    <!--**********************************
       Support ticket button start
    ***********************************-->

    <!--**********************************
       Support ticket button end
    ***********************************-->


</div>
<!--**********************************
    Main wrapper end
***********************************-->

<!--**********************************
    Scripts
***********************************-->
<!-- Required vendors -->
<script src="/vendor/global/global.min.js"></script>
<script src="/vendor/bootstrap-select/dist/js/bootstrap-select.min.js"></script>
<script src="/vendor/chart.js/Chart.bundle.min.js"></script>
<script src="/js/custom.min.js"></script>
<script src="/js/deznav-init.js"></script>
<!-- Apex Chart -->
<script src="/vendor/apexchart/apexchart.js"></script>
<script>
    $(function () {
        monitorInfo();
    });
    /**
     * 监控信息
     */
    function monitorInfo() {
        $("#dataTime").html("<span style='color:blue;'>数据获取时间  "+datefomate(new Date().getTime())+"</span>");
        //服务器相关
        ajaxGetTodo("/actuator/metrics/system.cpu.count", function (data) {
            $("#system-cpu-count").html("<span>" + data.measurements[0].value + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/system.cpu.usage", function (data) {
            $("#system-cpu-usage").html("<span>" + sysConvert(data.measurements[0].value) + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/process.uptime", function (data) {
            $("#process-uptime").html("<span>" + data.measurements[0].value + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/process.start.time", function (data) {
            $("#process-start-time").html("<span>" + datefomate(data.measurements[0].value * 1000) + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/process.cpu.usage", function (data) {
            $("#process-cpu-usage").html("<span>" + sysConvert(data.measurements[0].value) + "</span>")
        });
        //JVM相关
        ajaxGetTodo("/actuator/metrics/jvm.memory.max", function (data) {
            $("#jvm-memory-max").html("<span>" + jvmConvert(data.measurements[0].value) + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.memory.committed", function (data) {
            $("#jvm-memory-committed").html("<span>" + jvmConvert(data.measurements[0].value) + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.memory.used", function (data) {
            $("#jvm-memory-used").html("<span>" + jvmConvert(data.measurements[0].value) + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.buffer.memory.used", function (data) {
            $("#jvm-buffer-memory-used").html("<span>" + jvmConvert(data.measurements[0].value) + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.buffer.count", function (data) {
            $("#jvm-buffer-count").html("<span>" + data.measurements[0].value + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.threads.daemon", function (data) {
            $("#jvm-threads-daemon").html("<span>" + data.measurements[0].value + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.threads.live", function (data) {
            $("#jvm-threads-live").html("<span>" + data.measurements[0].value + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.threads.peak", function (data) {
            $("#jvm-threads-peak").html("<span>" + data.measurements[0].value + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.classes.loaded", function (data) {
            $("#jvm-classes-loaded").html("<span>" + data.measurements[0].value + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.classes.unloaded", function (data) {
            $("#jvm-classes-unloaded").html("<span>" + data.measurements[0].value + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.gc.memory.allocated", function (data) {
            $("#jvm-gc-memory-allocated").html("<span>" + jvmConvert(data.measurements[0].value) + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.gc.memory.promoted", function (data) {
            $("#jvm-gc-memory-promoted").html("<span>" + jvmConvert(data.measurements[0].value) + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.gc.max.data.size", function (data) {
            $("#jvm-gc-max-data-size").html("<span>" + jvmConvert(data.measurements[0].value) + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.gc.live.data.size", function (data) {
            $("#jvm-gc-live-data-size").html("<span>" + jvmConvert(data.measurements[0].value) + "</span>")
        });
        ajaxGetTodo("/actuator/metrics/jvm.gc.pause", function (data) {
            $("#jvm-gc-pause-count").html("<span>" + data.measurements[0].value + "</span>")
            $("#jvm-gc-pause-total-time").html("<span>" + data.measurements[1].value + "</span>")
        });
    }

    function sysConvert(value) {
        return Number(value * 100).toFixed(2);
    }

    function jvmConvert(value) {
        return Number(value / 1048576).toFixed(3);
    }

    //格式华日期为2017-12-20
    function datefomate(value) {
        if(value==null || value == undefined){
            return "";
        }
        var date = new Date(value);

        Y = date.getFullYear(),
                m = date.getMonth()+1,
                d = date.getDate(),
                H = date.getHours(),
                i = date.getMinutes(),
                s = date.getSeconds();
        return Y+'-'+m+'-'+d+" "+H+":"+i+":"+s;
    };
    function closeED(){
        alert("此功能未开放");
    }
    /*function dateMoment(value) {
        return moment(value).format('YYYY-MM-DD HH:mm:ss');
    }*/
    function ajaxGetTodo(url,func){
        var host = "http://" + "${hrefA!}";//$("#remoteHost").val();
        $.get(host+url,func);
    }
</script>





</body>

</html>