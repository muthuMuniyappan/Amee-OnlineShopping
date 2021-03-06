<%@include file="../flows-shared/flows-header.jsp" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
	
	<div class="container">
		
		
		<div class="row">
			
			<div class="col-md-6 col-md-offset-3">
				
				<div class="panel panel-primary">
				
					<div class="panel-heading">
						<h4>Sign Up - Address</h4>
					</div>
					
					<div class="panel-body">
										
						<sf:form class="form-horizontal" id="billingForm" method="POST" 
						modelAttribute="billing"	
						>
						
							
							<div class="form-group">
								<label class="control-label col-md-4" for="addressLineOne">Address Line One</label>
								<div class="col-md-8">
									<sf:input type="text" path="addressLineOne" class="form-control"
										placeholder="Enter Address Line One" />
										
										<sf:errors path="addressLineOne" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="addressLineTwo">Address Line Two</label>
								<div class="col-md-8">
									<sf:input type="text" path="addressLineTwo" class="form-control"
										placeholder="Enter Address Line Two" />	
										
										<sf:errors path="addressLineTwo" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="city">City</label>
								<div class="col-md-8">
									<sf:input type="text" path="city" class="form-control"
										placeholder="Enter City Name" />
										
										<sf:errors path="city" cssClass="help-block" element="em" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-md-4" for="postalCode">Postal Code</label>
								<div class="col-md-8">
									<sf:input type="text" path="postalCode" class="form-control"
										placeholder="XXXXXX" />
										
										<sf:errors path="postalCode" cssClass="help-block" element="em" />
								</div>
							</div>							
						
							<div class="form-group">
								<label class="control-label col-md-4" for="state">State</label>
								<div class="col-md-8">
									<sf:input type="text" path="state" class="form-control"
										placeholder="Enter State Name" />
										
										<sf:errors path="state" cssClass="help-block" element="em" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-md-4" for="country">Country</label>
								<div class="col-md-8">
									<sf:input type="text" path="country" class="form-control"
										placeholder="Enter Country Name" />	
										
										<sf:errors path="country" cssClass="help-block" element="em" />								
								</div>
							</div>
							
							
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
								<!-- Submit button for moving back to the personal -->
									<button type="submit" name="_eventId_personal" class="btn btn-primary">
										<span class="glyphicon glyphicon-chevron-left"> </span> Previous &#160;
									</button>		
								<!-- Submit button for moving next to the confirm -->					
									<button type="submit" name="_eventId_confirm" class="btn btn-primary"> &#160;
										Next <span class="glyphicon glyphicon-chevron-right"></span>
									</button>																	 
								</div>
							</div>						
						
						</sf:form>					
					
					</div>			
				
				</div>			
			
			</div>	
		
		</div>		
		
	</div>

<%@include file="../flows-shared/flows-footer.jsp" %>	

