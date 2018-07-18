$(function() {
	// Solving Active menu problems

	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	case 'User Cart':
		$('#userCart').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
	// --------------------------------------------------------------------

	// To tackle the csrf token

	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0 ){
		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options){
			xhr.setRequestHeader(header, token);
			
		}); 
		
	}

	// --------------------------------------------------------------------------------
	// Code for jQuery DataTable

	var $table = $('#productListTable');

	// Execute the below code only where we have this code
	if ($table.length) {
		// console.log('Inside the table');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({

					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 5,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {

									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg"/>';
								}

							},
							{
								data : 'name'
							},

							{
								data : 'brand'
							},

							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red"> Out of Stock <span>';
									}
									return data;
								}
							},

							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var string = '';
									string += '<a href="'+ window.contextRoot+ '/show/'+ data+ '/product" class="btn btn-primary"> <span class="glyphicon glyphicon-eye-open"> </span>  </a> &#160;';
									
									if(userRole=='ADMIN'){
										string += '<a href="'+ window.contextRoot+ '/manage/'+data+'/product" class="btn btn-warning"> <span class="glyphicon glyphicon-pencil"> </span> </a>';
									}
									
									else{
									if (row.quantity < 1) {

										string += '<a href="javascript:void(0)" class="btn btn-success disabled"> <span class="glyphicon glyphicon-shopping-cart"> </span> </a>';
									} 
									else 
									{																		
																		
										string += '<a href="'+ window.contextRoot+ '/cart/add/'+ data + '/product" class="btn btn-success"> <span class="glyphicon glyphicon-shopping-cart"> </span> </a>';
																		
									}
									}
									return string;
								}
							} ]

				});
	}

	// Dismissing the alert after 3 seconds
	var $alert = $('.alert');

	if ($alert.length) {

		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000)
	}
	// ------------------------------------------------------

	$('.switch input[type="checkbox"]')
			.on(
					'change',
					function() {

						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dMsg = (checked)? 'You want to activate the product?'
								: 'You want to de-activite the product?';
						var value = checkbox.prop('value');
						bootbox
								.confirm({
									size : 'medium',
									title : 'Product Activation/Deactivation',
									message : dMsg,
									callback : function(confirmed) {

										if (confirmed) {
											 console.log(value);
											bootbox
													.alert({
														size : 'medium',
														title : 'Information',
														message : 'You are going to perform operation on Product'
																+ value
													});
										} else {
											checkbox.prop('checked', !checked);
										}
									}

								});

					});
	// --------------------------------------------------------------
	// Data Table for Admin
	// --------------------------------------------------------------

	var $adminProductsTable = $('#adminProductsTable');

	// Execute the below code only where we have this code
	if ($adminProductsTable.length) {
		// console.log('Inside the table');

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable
				.DataTable({

					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},

					columns : [
							{
								data : 'id'
							},

							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg"/>';
								}
							},
							{
								data : 'name'
							},

							{
								data : 'brand'
							},

							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red"> Out of Stock <span>';
									}
									return data;
								}
							},

							{
								data : 'unitPrice',
								bSortable : false,
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},

							{
								data : 'active',
								mRender : function(data, type, row) {
									var string = '';
									
									string += '<label class="switch">';
									if (data) {
										string += '<input type="checkbox" checked="checked" value="'+ row.id + '" />';
									} 
									else {
										string += '<input type="checkbox" value="'+ row.id + '" />';
									}

									string += '<div class="slider"></div></label>';
									return string;
								}
							},

							{
								data : 'id', 
								bSortable : false,
								mRender : function(data, type, row) {
									var string = '';

									string += '<a href="'
											+ window.contextRoot
											+ '/manage/'
								  			+ data
											+ '/product" class="btn btn-warning">';
									string += '<span class="glyphicon glyphicon-pencil"></span></a>';

									return string;

								}

							} ],

					// --------------------- init()-------------------------//

					initComplete : function() {

						var api = this.api();

						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {

											var checkbox = $(this);
											var checked = checkbox
													.prop('check');
											var dMsg = (this.checked) ? 'You want to activate the product?'
													: 'You want to de-activite the product?';
											var value = checkbox.prop('value');
											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activation/Deactivation',
														message : dMsg,
														callback : function(
																confirmed) {

															if (confirmed) {
																console
																		.log(value);

																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';

					$.post(activationUrl,function(data) {
						bootbox.alert({
							size : 'medium',
							title : 'Information',
							message : data
							});
					});

							} 
							else {
								checkbox.prop('checked',!checked)
								}
									}
								})

							});
					}

				});
	}

	// -------------------------------------------------------------
 
 	// validation code for category

	var $categoryForm = $('#categoryForm');

	if ($categoryForm.length) {
		$categoryForm
				.validate({

					rules : {
						name : {
							required : true,
							minlength : 2
						},

						description : {
							required : true
						}
					},

					messages : {
						name : {
							required : 'Please add the category name!',
							minlength : 'The Category name should not be less than 2 characters'
						},

						description : {
							required : 'please add a description for this category!'
						}
					},

					errorElement : 'em',
					errorPlacement : function(error, element) {
						// add the class of help-block
						error.addClass('help-block');
						// add the error element after the input element
						error.insertAfter(element);
					}
				});
	}

	// -----------------------------------------------------------------------

	// -------------------------------------------------------------

	// validation code for login

	var $loginForm = $('#loginForm');

	if ($loginForm.length) {
		$loginForm.validate({

			rules : {
				username : {
					required : true,
					email : true
				},

				password : {
					required : true
				}
			},

			messages : {
				username : {
					required : 'Please enter the username!',
					email : 'Please enter valid email address!'
				},

				password : {
					required : 'please enter the password!'
				}
			},

			errorElement : 'em',
			errorPlacement : function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add the error element after the input element
				error.insertAfter(element);
			}
		});
	}

	// -----------------------------------------------------------------------
	
	// handing the click event of refreshCart button
	
	$('button[name="refreshCart"]').click(function(){
		
		// fetch the cart line Id
		var cartLineId= $(this).attr('value');
		var countElement= $('#count_'+cartLineId);
		
		var originalCount= countElement.attr('value');
		var currentCount= countElement.val();
		
		//work only when the count has changed
		if(currentCount != originalCount){
			
			if(currentCount < 1 || currentCount > 3){
				//reverting back to the original count, if user has given value below 1 and above 3
				countElement.val(originalCount);
				bootbox.alert({
					
					size: 'medium',
					title: 'Error',
					message: 'product count should be minimum 1 and maximum 3'						
				});				
			}
			else{
				
				var updateUrl= window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
				//forward it to the controller
				window.location.href= updateUrl;				
			}
			
		}	
		
	});
	
	

	
	//--------------------------------------------------------------------------
});