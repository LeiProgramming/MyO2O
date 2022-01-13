/**
 *
 */

$(function () {
        var initUrl = '/o2o/shop/getShopinitinfo';
        var registerShopUrl = '/o2o/shopadmin/registershop'

        function getShopInitInfo() {
            $.getJSON(initUrl, function (data) {
                if (data.success) {
                    var tempHtml = '';
                    var tempAreaHtml = '';
                    data.shopCategoryList.map(function (item, index) {
                        tempHtml += '<option data-id=""' + item.shopCategoryId + '">'
                            + item.shopCategoryName + '</option>';
                    });
                    data.areaList.map(function (item, index) {
                        tempHtml += '<option data-id=""' + item.areaId + '">'
                            + item.areaName + '</option>';
                    });
                    $('#shop-category').html(tempHtml);
                    $('#area').html(tempAreaHtml);
                }
            });
            $('#submit').click(function () {
                var shop = {};
                shop.shopName = $('#shop-name').val();
                shop.shopAddr = $('#shop-addr').val();
                shop.phone = $('#shop-phone').val();
                shop.shopDesc = $('#shop-desc').val();

            })
        }
    }
)