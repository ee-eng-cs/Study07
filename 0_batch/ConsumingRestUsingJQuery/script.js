$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/company"
    }).then(function(data) {
       $('.company-id').append(data.id);
       $('.company-name').append(data.name);
    });
});
