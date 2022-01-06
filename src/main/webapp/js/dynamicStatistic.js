$(document).ready(function() {
    $(".btn").click(
        function () {
            $.ajax({
                url: $(this).children(".url").html(),
                dataType: "json",
                type: "POST",
                success: function (res) {
                    $(".chart .item").remove();
                    for (let index in res.data) {
                        let appendstr = "<tr class='item'>"
                        appendstr += "<td>" + res.data[index]["userName"] + "</td>";
                        appendstr += "<td>" + res.data[index]["userNum"] + "</td>";
                        appendstr += "<td>" + res.data[index]["college"]["collegeName"] + "</td>";
                        appendstr += "<td>" + (res.data[index]["sex"] ? "男" : "女") + "</td>";
                        appendstr += "<td>" + (res.data[index]["state"] == null ? '未填写' : (res.data[index]["state"] == 1 ? '高危' : '正常')) + "</td>";
                        appendstr += "<td>" + (res.data[index]["telephone"] == null ? "未填写" : res.data[index]["telephone"]) + "</td>";
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
                $(".side-nav").css("width", "0");
                $(".side-nav .items").css("display", "none");
                $(".container").css("padding-left", "0");
            } else {
                $(".side-nav").css("width", "13rem");
                $(".side-nav .items").css("display", "block");
                $(".container").css("padding-left", "13rem");
            }
        }
    );
});
