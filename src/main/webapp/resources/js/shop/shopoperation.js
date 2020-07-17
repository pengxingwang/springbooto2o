/**
 * 
 */
var shopImg;
$(function() {
	// 从URL里获取shopId参数的值
	var shopId = getQueryString('shopId');
	// 由于店铺注册和编辑使用的是同一个页面，
	// 该标识符用来标明本次是添加还是编辑操作
	var isEdit = shopId ? true : false;
	// 用于店铺注册时候的店铺类别以及区域列表的初始化的URL
	var initUrl = '/o2o/shopadmin/getshopinitinfo';
	// 注册店铺的URL
	var registerShopUrl = '/o2o/shopadmin/registershop';
	// 编辑店铺前需要获取店铺信息，这里为获取当前店铺信息的URL
	var shopInfoUrl = "/o2o/shopadmin/getshopbyid?shopId=" + shopId;
	// 编辑店铺信息的URL
	var editShopUrl = '/o2o/shopadmin/modifyshop';
	// 判断是编辑操作还是注册操作
	if (!isEdit) {
		getShopInitInfo();
	} else {
		getShopInfo(shopId);
	}
	// 通过店铺Id获取店铺信息
	function getShopInfo(shopId) {
		$.getJSON(shopInfoUrl, function(data) {
			if (data.code === 0) {

				var tempHtml = '';
				var tempAreaHtml = '';
				data.data.shopCategoryList.map(function(item, index) {
					tempHtml += '<option data-id="' + item.shopCategoryId
						+ '"selected>' + item.shopCategoryName + '</option>';
				});
				data.data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '"selected>'
						+ item.areaName + '</option>';
				});
				$('#shop-category').html(tempHtml);
				$('#area').html(tempAreaHtml);

				// 若访问成功，则依据后台传递过来的店铺信息为表单元素赋值
				var shop = data.data.shop;
				$('#shop-name').val(shop.shopName);
				$('#shop-addr').val(shop.shopAddr);
				$('#shop-phone').val(shop.phone);
				$('#shop-desc').val(shop.shopDesc);
			}
		});
	}
	// 取得所有二级店铺类别以及区域信息，并分别赋值进类别列表以及区域列表
	function getShopInitInfo() {
		$.getJSON(initUrl, function(data) {
			console.log(data.data)
			if (data.code === 0) {
				var tempHtml = '';
				var tempAreaHtml = '';
				data.data.shopCategoryList.map(function(item, index) {
					tempHtml += '<option data-id="' + item.shopCategoryId
							+ '">' + item.shopCategoryName + '</option>';
				});
				data.data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaName + '</option>';
				});
				$('#shop-category').html(tempHtml);
				$('#area').html(tempAreaHtml);
			}
		});
	}



	// 提交按钮的事件响应，分别对店铺注册和编辑操作做不同响应
	$('#submit').click(function() {
		// 创建shop对象
		var shop = {};
		if (isEdit) {
			// 若属于编辑，则给shopId赋值
			shop.shopId = shopId;
		}
		// 获取表单里的数据并填充进对应的店铺属性中
		shop.shopName = $('#shop-name').val();
		shop.shopAddr = $('#shop-addr').val();
		shop.phone = $('#shop-phone').val();
		shop.shopDesc = $('#shop-desc').val();
		// 选择选定好的店铺类别
		shop.shopCategoryId =  $('#shop-category').find('option').not(function() {
				return !this.selected;
			}).data('id')
		// 选择选定好的区域信息
		shop.areaId = $('#area').find('option').not(function() {
				return !this.selected;
			}).data('id')
		// 获取上传的图片文件流
		shop.shopImg = shopImg;
		var verifyCodeActual = $('#j_captcha').val();
		if (!verifyCodeActual) {
			$.toast('请输入验证码！');
			return;
		}
		// formData.append('verifyCodeActual', verifyCodeActual);
        shop.verifyCodeActual = verifyCodeActual;
		// 将数据提交至后台处理相关操作
		$.ajax({
			url : (isEdit ? editShopUrl : registerShopUrl),
			type : 'POST',
			data : JSON.stringify(shop),
			dataType: 'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				if (data.code === 0) {
					$.toast('提交成功！');
					if (!isEdit) {
						// 若为注册操作，成功后返回店铺列表页
						window.location.href = "/o2o/shopadmin/shoplist";
					}
				} else {
					$.toast('提交失败！' + data.msg);
				}
				// 点击验证码图片的时候，注册码会改变
				$('#captcha_img').click();
			}
		});
	});

})

function uploadFile(){
	var shopImgFile = $('#shop-img')[0].files[0];
	var formData = new FormData();
	formData.append('file', shopImgFile);
	$.ajax({
		type : 'POST',
		url: '/o2o/upload/img',
		data: formData,
		contentType : false,
		processData : false,
		cache : false,
		success : function(data) {
			if (data.code === 0) {
				shopImg = data.data
				$.toast('提交成功！');
			} else {
				$.toast('提交失败！' + data.msg);
			}
		}
	})
}
