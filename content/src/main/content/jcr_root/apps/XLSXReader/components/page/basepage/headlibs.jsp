<%@page session="false"%>
<%@include file="/apps/XLSXReader/global/global.jsp"%>
<%@taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0" %>
<cq:defineObjects/>

<cq:includeClientLib categories="cq.foundation-main"/><%
%><cq:include script="/libs/cq/cloudserviceconfigs/components/servicelibs/servicelibs.jsp"/><%
    currentDesign.writeCssIncludes(pageContext); %>

<cq:includeClientLib css="XLSXReader.all"/>
<cq:includeClientLib js="XLSXReader.all"/>