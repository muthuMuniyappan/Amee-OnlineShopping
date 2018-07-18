<%@include file="../flows-shared/flows-header.jsp" %>

<div class="container">
	
	<div class="row">
		
		<!-- Column to display the personal details -->
		<div class="col-sm-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4> Personal Details </h4>
				</div>
				
				<div class="panel-body">
					<div class="text-center">
					<h4> ${registerModel.user.firstName} ${registerModel.user.firstName} </h4>					
					<h3>Email: ${registerModel.user.email}</h3>
					<h3>Contact Number: ${registerModel.user.contactNumber}</h3>
					<h3>Role: ${registerModel.user.role}</h3>					
					</div>
				</div>
				<div class="panel-footer">
					<!-- anchor to move to the edit of address -->
					<a href="${flowExecutionUrl}&_eventId_personal"	class="btn btn-lg btn-primary"> Edit </a>
				</div>
			</div>

		</div>
		
		
		
		<div class="col-sm-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Billing Address</h4>
				</div>
				
				<div class="panel-body">
					<!-- code to display the communication address -->
					<div class="text-center">
					<h3> ${registerModel.billing.addressLineOne}</h3>
					<h3> ${registerModel.billing.addressLineTwo}</h3>
					<h3> ${registerModel.billing.city} - ${registerModel.billing.postalCode} </h3>
					<h3> ${registerModel.billing.state} -  ${registerModel.billing.country}</h3>								
					</div>
				</div>
				<div class="panel-footer">
					<!-- anchor to move to the edit of address -->
					<a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-lg btn-primary"> Edit </a>
				</div>
			</div>

		</div>
	
	</div>
	
	<!-- to provide a confirm button after displaying the details -->
	<div class="row">
		
		<div class="col-sm-4 col-sm-offset-4">
			
			<div class="text-center">
				
				<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">Confirm</a>
				
			</div>
			
		</div>
		
	</div>

</div>

<%@include file="../flows-shared/flows-footer.jsp" %>