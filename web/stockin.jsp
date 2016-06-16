<%--
  Created by IntelliJ IDEA.
  User: imxqd
  Date: 2016/6/15
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>

<div class="container">
    <div class="panel panel-default" style="margin-top: 80px">
        <div class="panel-heading">
            图书供应信息
            <button id="stockinBtn" data-toggle="modal" data-target="#myModal" style="margin-left: 85%" class="btn btn-primary">提交</button>
        </div>
        <div class="table-responsive">
            <table role="grid" id="DataTables_Table_1"class="table table-striped table-bordered table-hover m-b-none">
                <thead>
                <tr role="row">
                    <th>编号</th>
                    <th>ISBN</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>售价</th>
                    <th>数目</th>
                </tr>
                </thead>
                <tbody id="saleRecordBody">
                <%--<%--%>
                    <%--for (int i = 0; i < 5; i++) {--%>
                <%--%>--%>
                <tr class="odd" role="row">
                    <td>1</td>
                    <td>123567</td>
                    <td>Three body problem</td>
                    <td>Liu Cixin</td>
                    <td>清华大学出版社</td>
                    <td>￥45</td>
                    <td style="width: 10%"><input type="number" style="width: 80px;"></td>
                </tr>

                <tr class="odd" role="row">
                    <td>2</td>
                    <td>133567</td>
                    <td>软件项目管理</td>
                    <td>朱少民</td>
                    <td>人民邮电出版社</td>
                    <td>￥55</td>
                    <td style="width: 10%"><input type="number" style="width: 80px;"></td>
                </tr>

                <tr class="odd" role="row">
                    <td>3</td>
                    <td>323567</td>
                    <td>软件测试方法和技术</td>
                    <td>朱少民</td>
                    <td>清华大学出版社</td>
                    <td>￥45</td>
                    <td style="width: 10%"><input type="number" style="width: 80px;"></td>
                </tr>

                <%--<%--%>
                    <%--}--%>
                <%--%>--%>
                </tbody>
            </table>
        </div>

    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">进货订单详细</h4>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <table role="grid" id="DataTables_Table_"class="table table-striped m-b-none">
                        <thead>
                        <tr role="row">
                            <th>编号</th>
                            <th>ISBN</th>
                            <th>书名</th>
                            <th>作者</th>
                            <th>出版社</th>
                            <th>售价</th>
                            <th>数目</th>
                        </tr>
                        </thead>
                        <tbody id="buydetailbody">
                        <tr class="odd" role="row">
                            <td>1</td>
                            <td>123567</td>
                            <td>Three body problem</td>
                            <td>Liu Cixin</td>
                            <td>清华大学出版社</td>
                            <td>￥45</td>
                            <td>300</td>
                        </tr>
                        <tr class="odd" role="row">
                            <td>2</td>
                            <td>133567</td>
                            <td>软件项目管理</td>
                            <td>朱少民</td>
                            <td>人民邮电出版社</td>
                            <td>￥55</td>
                            <td>500</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="stockInSubmit" class="btn btn-success">进货</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!-- Modal end-->

<script type="text/javascript">
    $(document).ready(function() {
        $('#mynav').find('li').each(function (i) {
            if (i == 0)
                $(this).addClass('active');
        });

        $('#stockinBtn').click(function () {
            var isNotAllEmpty = false;
            $('#saleRecordBody').find('input').each(function(i) {
                console.log($(this).val());
                if($(this).val() != "") {
                    isNotAllEmpty = true;
                }
            });

            if(!isNotAllEmpty) {
                alert("进货信息为空");
                return false;
            }
        });



//        $('#stockin')
//        $('#stokinDetail').append($('<tr class="odd" role="row"><td class="sorting_1">ISBN</td><td>ISBN</td></tr><tr><td>书名</td></tr>'));
    });
</script>
</body>
</html>