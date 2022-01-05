$(document).ready(function() {
    $(".state .btn").click(
        function () {
            $.ajax({
                url: $(this).children(".url").html(),
                dataType: "json",
                type: "POST",
                success: function (res) {
                    $(".chart .item").remove();
                    for (let index in res) {
                        let appendstr = "<tr class='item'>"
                        appendstr += "<td>" + res[index]["userName"] + "</td>";
                        appendstr += "<td>" + res[index]["userNum"] + "</td>";
                        appendstr += "<td>" + res[index]["collegeName"] + "</td>";
                        appendstr += "<td>" + res[index]["sex"] + "</td>";
                        appendstr += "<td>" + res[index]["state"] + "</td>";
                        appendstr += "<td>" + res[index]["telephone"] + "</td>";
                        appendstr += "</tr>";
                        $(".chart").append(appendstr);
                    }
                },
                error: function (error) {
                    $(".chart .item").remove();
                    console.log(error);
                },
                beforeSend: function () {
                    $(".loader").css("visibility", "visible");
                },
                complete: function () {
                    $(".loader").css("visibility", "hidden");
                }
            });
        }
    );

    $("#modal-button").click(
        function () {
            $(".modal").css("display", "flex");
        }
    );

    $(".modal .close").click(
        function () {
            $(".modal").css("display", "none");
        }
    );

    $(window).click(
        function (event) {
            if (event.target == $(".modal")[0]) {
                $(".modal").css("display", "none");
            }
        }
    );

    $(".menu-button").click(
        function () {
            if ($(".side-nav .items").css("display") == "block") {
                $(".side-nav").css("width","0");
                $(".side-nav .items").css("display","none");
                $(".container").css("padding-left","0");
            } else {
                $(".side-nav").css("width","13rem");
                $(".side-nav .items").css("display","block");
                $(".container").css("padding-left","13rem");
            }
        }
    );

});