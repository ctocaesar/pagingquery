<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">

    <link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <link href="jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css"
          rel="stylesheet"/>

    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript"
            src="jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>

    <link rel="stylesheet" type="text/css" href="jquery/bs_pagination/jquery.bs_pagination.min.css">
    <script type="text/javascript" src="jquery/bs_pagination/jquery.bs_pagination.min.js"></script>
    <script type="text/javascript" src="jquery/bs_pagination/en.js"></script>
    <!--
        考试题：
            新建学生表 tbl_student
            表结构
            id：主键
            name：学生姓名
            gender：学生性别
            address：家庭地址
            phone：联系电话
    -->
    <script type="text/javascript">
        $(function () {
            pagingQuery(1, 10);
            $("#searchBtn").click(function () {
                $("#hidden-name").val($.trim($("#student-name").val()));
                $("#hidden-gender").val($.trim($("#student-gender").val()));
                $("#hidden-address").val($.trim($("#student-address").val()));
                $("#hidden-phone").val($.trim($("#student-phone").val()));

                pagingQuery(1, $("#studentPage").bs_pagination('getOption', 'rowsPerPage'));
            });
            $("#checkedAll").click(function () {
                $("input[name=checked]").prop("checked", this.checked);
            });

            $("#studentInfoBody").on("click", $("input[name=checked]"), function () {
                $("#checkedAll").prop("checked", $("input[name=checked]").length == $("input[name=checked]:checked").length);
            });

        });

        function pagingQuery(pageNo,pageSize) {
            $("#checkedAll").prop("checked",false);
            $("#student-name").val($.trim($("#hidden-name").val()));
            $("#student-gender").val($.trim($("#hidden-gender").val()));
            $("#student-address").val($.trim($("#hidden-address").val()));
            $("#student-phone").val($.trim($("#hidden-phone").val()));
            $.ajax({
                url: "student/pagingQuery.do",
                data: {
                    "pageNo": pageNo,
                    "pageSize": pageSize,
                    "name": $("#student-name").val(),
                    "gender": $("#student-gender").val(),
                    "address": $("#student-address").val(),
                    "phone": $("#student-phone").val()
                },
                type: "get",
                dataType: "json",
                success: function (data) {
                    var html = "";
                    $.each(data.studentList, function (i, n){
                        html += "<tr>";
                        html += "<td><input type='checkbox' name='checked' /> </td>";
                        html += "<td>" + n.name + "</td>";
                        html += "<td>" + n.gender + "</td>";
                        html += "<td>" + n.address + "</td>";
                        html += "<td>" + n.phone + "</td>";
                        html += "</tr>";

                    });

                    $("#studentInfoBody").html(html);
                    var totalPages = data.total%pageSize==0?data.total/pageSize:parseInt(data.total/pageSize)+1;
                    $("#studentPage").bs_pagination({
                        currentPage: pageNo, // 页码
                        rowsPerPage: pageSize, // 每页显示的记录条数
                        maxRowsPerPage: 20, // 每页最多显示的记录条数
                        totalPages: totalPages, // 总页数
                        totalRows: data.total, // 总记录条数

                        visiblePageLinks: 3, // 显示几个卡片

                        showGoToPage: true,
                        showRowsPerPage: true,
                        showRowsInfo: true,
                        showRowsDefaultInfo: true,

                        //该函数是在我们点击分页组件的时候触发
                        onChangePage: function (event, data) {
                            pagingQuery(data.currentPage, data.rowsPerPage);
                        }
                    });
                }
            });

        }

        /* */

    </script>
</head>
<body>
<!--
    <input type="hidden" id="hidden-name" />
    <input type="hidden" id="hidden-gender" />
    <input type="hidden" id="hidden-address" />
    <input type="hidden" id="hidden-phone" />
-->
<input type="hidden" id="hidden-name" value=""/>
<input type="hidden" id="hidden-gender" value=""/>
<input type="hidden" id="hidden-address" value=""/>
<input type="hidden" id="hidden-phone" value=""/>
<div>
    <div style="position: relative; left: 10px; top: -10px;">
        <div class="page-header">
            <h3>学生信息列表</h3>
        </div>
    </div>
</div>
<div style="position: relative; top: -20px; left: 0px; width: 100%; height: 100%;">
    <div style="width: 100%; position: absolute;top: 5px; left: 10px;">

        <div class="btn-toolbar" role="toolbar" style="height: 80px;">
            <form class="form-inline" role="form" style="position: relative;top: 8%; left: 5px;">

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">学生姓名</div>
                        <input class="form-control" type="text" id="student-name">
                    </div>
                </div>

                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">学生性别</div>
                        <input class="form-control" type="text" id="student-gender">
                    </div>
                </div>


                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">家庭地址</div>
                        <input class="form-control" type="text" id="student-address"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <div class="input-group-addon">联系电话</div>
                        <input class="form-control" type="text" id="student-phone">
                    </div>
                </div>

                <button type="button" id="searchBtn" class="btn btn-default">查询</button>

            </form>
        </div>
        <div class="btn-toolbar" role="toolbar"
             style="background-color: #F7F7F7; height: 50px; position: relative;top: 5px;">
            <div class="btn-group" style="position: relative; top: 18%;">

            </div>

        </div>
        <div style="position: relative;top: 10px;">

            <table class="table table-hover">
                <thead>
                <tr style="color: #B3B3B3;">
                    <td><input type="checkbox" id="checkedAll"/></td>
                    <td>学生姓名</td>
                    <td>学生性别</td>
                    <td>家庭地址</td>
                    <td>联系电话</td>
                </tr>
                </thead>

                <tbody id="studentInfoBody">


                </tbody>
            </table>
        </div>

        <div style="height: 50px; position: relative;top: 30px;">

            <div id="studentPage"></div>

        </div>

    </div>

</div>
</body>
</html>