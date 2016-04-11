<div id="content">
  <fieldset>
    <legend>Movie Comments:</legend>
    <br>
    <table>
    <tbody><tr>
        <th>Movie Name</th>  <th>Customer Name</th> <th>Rating</th> <th>Comment</th> 
    </tr>
    <#list model["comments"] as comment>
        <tr>
        <td>${comment.bookingHistory.showtime.movie.name}</td> 
        <td>${comment.bookingHistory.customer.userName}</td>
        <td>${comment.rating}</td>
        <td>${comment.comment}</td>
    </tr>
    </#list>
  </tbody></table>
  </fieldset>
</div>
