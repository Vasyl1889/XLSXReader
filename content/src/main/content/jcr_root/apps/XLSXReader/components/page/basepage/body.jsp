<%@page session="false"%>
<%@include file="/apps/XLSXReader/global/global.jsp"%>
<%@taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0" %>
<cq:defineObjects/>

<body>
    <div class="container_12">
        <header class="header clearfix">
            <div class="grid_4 logo">Test Project</div>
            <div class="grid_8 nav">
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Page 1</a></li>
                    <li><a href="#">Page 2</a></li>
                </ul>
            </div>
        </header>

        <hr/>

        <div class="page-content">
           <cq:include script="main.jsp"/>
        </div>

        <hr/>

        <footer class="footer clearfix">
            2015 Test Project
        </footer>

    </div>

    <cq:includeClientLib js="XLSXReader.all"/>
</body>