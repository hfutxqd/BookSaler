<%--
  Created by IntelliJ IDEA.
  User: imxqd
  Date: 2016/6/15
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
                    <th>销售编号</th>
                    <th>ISBN</th>
                    <th>书名</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>售价</th>
                    <th>销量</th>
                    <th>总价</th>
                    <th>销售日期</th>
                </tr>
                </thead>
                <tbody id="saleRecordBody">
                <s:iterator value="data">

                    <tr class="odd" role="row">
                        <td><s:property value="sale_id" /></td>
                        <td><s:property value="book_name" /></td>
                        <td><s:property value="ISBN" /></td>
                        <td><s:property value="author" /></td>
                        <td><s:property value="publisher" /></td>
                        <td><s:property value="price" /></td>
                        <td><s:property value="stock_out_size" /></td>
                        <td><s:property value="total_price" /></td>
                        <td><s:property value="stock_out_date" /></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
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