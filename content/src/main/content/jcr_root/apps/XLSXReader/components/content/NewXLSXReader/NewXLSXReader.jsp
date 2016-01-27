<%@page session="false"%>
<%@include file="/apps/XLSXReader/global/global.jsp"%>
<%@taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0"%>
<cq:defineObjects />

<cq:includeClientLib css="xlsxreader.component" />
<cq:includeClientLib js="xlsxreader.component" />
<link rel="stylesheet" href="http://ui-grid.info/release/ui-grid.css" type="text/css">

<body ng-app="fupApp">
    <ng-view></ng-view>
    <br/>
<body>
