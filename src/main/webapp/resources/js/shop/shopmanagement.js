$(function() {
	var shopId = getQueryString('shopId');
	var shopInfoUrl = '/o2o/shopadmin/getshopmanagementinfo?shopId=' + shopId;
	$.getJSON(shopInfoUrl, function(data) {
		if (data.data.redirect) {
			window.location.href = data.data.url;
		} else {
			if (data.data.shopId != undefined && data.data.shopId != null) {
				shopId = data.data.shopId;
			}
			$('#shopInfo')
					.attr('href', '/o2o/shopadmin/shopoperation?shopId=' + shopId);
		}
	});
});