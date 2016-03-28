var myHeading = document.querySelector('h1');
myHeading.textContent = 'Hello world!';

$(document).ready(function() {
    $("a.button").hover(function() {
        $(this).siblings("h1").addClass("your_color_class");
    }, function() {
        $(this).siblings("h1").removeClass("your_color_class");
    });
});
