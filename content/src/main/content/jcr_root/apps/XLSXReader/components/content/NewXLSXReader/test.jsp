<div>
    <h2>Route and Resource Test</h2>
    <table>
        <tr ng-repeat="x in tc.names" ng-class-even="light-gray" ng-class-odd="dark-gray">
            <td>{{ x.Name }}</td>
            <td>{{ x.Country }}</td>
        </tr> 
    </table>
   	<a href="#/home">Back to Grid</a>
<div>