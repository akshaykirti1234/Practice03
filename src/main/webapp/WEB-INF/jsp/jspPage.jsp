<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
			<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="ISO-8859-1">
					<title>CSM-Assessment</title>

					<!-- DataTables and Data Table Buttons CSS -->
					<link rel="stylesheet"
						href="https://cdn.datatables.net/buttons/2.0.0/css/buttons.dataTables.min.css">
					<link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css">

					<!-- Bootstrap -->
					<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
						rel="stylesheet">
					<!-- Datepicker -->
					<link
						href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"
						rel="stylesheet">
					<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>



					<!-- Font Awesome -->
					<script src="https://kit.fontawesome.com/33de41b32e.js" crossorigin="anonymous"></script>

					<!-- jQuery -->
					<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

					<!-- jQuery Validator -->
					<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
					<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>

					<!-- DataTables -->
					<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

					<!-- DataTables Buttons -->
					<script src="https://cdn.datatables.net/buttons/2.4.2/js/dataTables.buttons.min.js"></script>

					<!-- JSZip -->
					<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>

					<!-- PDFMake -->
					<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
					<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>

					<!-- Buttons HTML5 -->
					<script src="https://cdn.datatables.net/buttons/2.4.2/js/buttons.html5.min.js"></script>

					<!-- Buttons Print -->
					<script src="https://cdn.datatables.net/buttons/2.4.2/js/buttons.print.min.js"></script>
					<!-- Column Visibility -->
					<script src="https://cdn.datatables.net/buttons/2.4.2/js/buttons.colVis.min.js"></script>

					<!-- Datepicker -->
					<script
						src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

					<!-- Favicon -->
					<link rel="icon"
						href="https://cdn.iconscout.com/icon/premium/png-512-thumb/website-webpage-visitor-male-optimization-seo-calculation-21-8803.png?f=avif&w=256">

					<style type="text/css">
						label {
							font-weight: bold;
						}

						body {
							background-image: url('');
							background-repeat: no-repeat;
							background-attachment: fixed;
							background-size: cover;
						}

						label.error {
							color: red;
						}
					</style>
				</head>

				<body>


					<nav class="navbar navbar-expand-md sticky-top">

						<!-- Navbar links -->
						<div class="collapse navbar-collapse" id="collapsibleNavbar">

							<ul class="navbar-nav ms-auto me-4 ">
								<li class="nav-item"><a class="nav-link" id="sudo" href="#"><i
											class="fa-solid fa-print"></i></i>
									</a></li>
							</ul>

						</div>
					</nav>


					<c:if test="${msg ne null}">
						<script>
							Swal.fire({
								icon: 'success',
								title: 'Success',
								text: '${msg}',
								// showConfirmButton: false,
								timer: 1500
							});
						</script>
					</c:if>

					<!-- Registration Form -->
					<div class="container mt-5 d-flex flex-column gap-5">
						<div>
							<form action="/saveEmp" method="post" id="empForm" enctype="multipart/form-data">
								<div class="card shadow bg-light rounded-3">
									<div class="card-header text-bg-dark">
										<h3>Employee Registration Form</h3>
									</div>
									<div class="card-body">
										<div class="row gap-3">
											<input type="hidden" name="empId" value="${employee.empId}">
											<div class="col-4">
												<label for="">Enter Employee Name</label>
												<input class="form-control" type="text" name="empName" id="empName"
													value="${employee.empName}">
											</div>
											<div class="col-3">
												<label for="">Enter Salary</label>
												<input class="form-control" type="text" name="empSalary" id="empSalary"
													value="${employee.empSalary}">
											</div>
											<div class="col-4">
												<label for="">Enter Email</label>
												<input class="form-control" type="text" name="empMail" id="empMail"
													value="${employee.empMail}">
											</div>
											<div class="col-3">
												<label for="">Enter Mobile No</label>
												<input class="form-control" type="text" name="empMobile" id="empMobile"
													value="${employee.empMobile}">
											</div>

											<div class="col-2">
												<label for="">DOB</label>
												<div class="input-group">
													<span class="input-group-text"><i
															class="fa-regular fa-calendar"></i></span>
													<input class="form-control" type="text" name="empDob" id="empDob"
														autocomplete="off" placeholder="dd-mm-yyyy"
														value='<fmt:formatDate value="${employee.empDob}" pattern="dd-MM-yyyy"/>'>

												</div>
											</div>
											<div class="col-3">
												<label for="">Photo</label>
												<input class="form-control" type="file" name="photo" id="photo">
												<span>${employee.empPhoto}</span>
											</div>

										</div>
									</div>
									<div class="card-footer text-center">
										<button class="btn btn-success" type="submit">${employee == null ?
											"Submit":"Update"}</button>
										<button class="btn btn-danger" type="reset">Reset</button>
										<c:if test="${employee != null}"><a href="/"><button
													class="btn btn-secondary">Cancel</button></a></c:if>
									</div>
								</div>
							</form>

						</div>




						<!-- Employee Details  -->
						<div class="card bg-light shadow rounded">
							<div class="card-header  text-bg-dark">
								<h3>Employee Details</h3>
							</div>
							<div class="card-body">
								<table class="table table-bordered table-hover" id="empTable">
									<thead class="bg-info-subtle">
										<tr>
											<th>Sl#</th>
											<th>Name</th>
											<th>Mobile No</th>
											<th>Email</th>
											<th>DOB</th>
											<th>Salary</th>
											<th>Photo</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${empList}" var="emp" varStatus="counter">
											<tr>
												<td>${counter.count}</td>
												<td>${emp.empName}</td>
												<td>${emp.empMobile}</td>
												<td>${emp.empMail}</td>
												<td>
													<fmt:formatDate value="${emp.empDob}" pattern="dd-MMM-yyyy" />
												</td>
												<td>${emp.empSalary}</td>
												<td>
													<img src="../../../resources/static/images/${emp.empPhoto}"
														alt="${emp.empPhoto}" width="100px" height="100px">
												</td>
												<td>
													<div class="d-flex gap-3">
														<a class="text-danger" href="/deleteEmp?empId=${emp.empId}"><i
																class="fa-solid fa-trash"></i></a>
														<a class="text-success" href="/editEmp?empId=${emp.empId}"><i
																class="fa-solid fa-pen-to-square"></i></a>
													</div>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class=" ms-auto me-2">
								<p><em>@CSM Tech</em></p>
							</div>
						</div>
					</div>


					<script type="text/javascript">
						document.addEventListener("DOMContentLoaded", () => {
							setTimeout(function () {
								document.getElementById('alertId').style.display = 'none';
							}, 3000);
						});

						function readURL(input) {
							if (input.files && input.files[0]) {
								var reader = new FileReader();

								reader.onload = function (e) {
									$('#preview-image').attr('src', e.target.result);
									$('#preview-image').show();
								}

								reader.readAsDataURL(input.files[0]);
							}
						}

						$("#photo").change(function () {
							readURL(this);
						});


						$("#photo").change(function () {
							$("#oldPhoto").hide();
						});

						//Bootstrap Date Picker
						$(function () {
							$("#empDob").datepicker({
								format: 'dd-mm-yyyy',
								autoclose: true,
								todayHighlight: true,
							});
						});

						//Form validation
						$().ready(function () {

							$.validator.addMethod("pwcheck", function (value) {
								return /^[A-Za-z0-9\d=!\-@._*]*$/.test(value) // consists of only these
									&& /[a-z]/.test(value) // has a lowercase letter
									&& /[A-Z]/.test(value) // has a Upper letter
									&& /\d/.test(value) // has a digit
									&& /^(?=.*[@#$%&])/.test(value)// has a special symbole
							}, "Password must contain one capital letter, one small letter,one numerical and one special character");

							// Add custom validation method for select tag
							$.validator.addMethod('valueNotEquals', function (value, element, param) {
								return param !== value;
							}, 'Please select an option');

							$("#empForm").validate({
								rules: {
									empName: "required",


									empMobile: {
										required: true,
										digits: true,
										rangelength: [10, 10],
									},
									empMail: {
										required: true,
										email: true,
									},
									empSalary: {
										required: true,
										number: true,

									},
									empDob: "required",
									// photo: "required",
								},
								messages: {
									empName: "Please Enter User Name",

									empMobile: {
										required: "Please enter phone no",
										digits: "must be digits only",
										rangelength: "Enter a 10 digits valid phone no"
									},
									empMail: {
										required: "please enter email id",
										email: "Enter a valid Email",
									},
									empSalary: {
										required: "Please Enter Salary",
										digits: "Invalid Salary",

									},
									empDob: "please enter you dob",
									// photo: "please Upload Your Photo",
								}
							});

						});

						// -------------------------- jQuery DataTable ------------------------------
						$(document).ready(function () {
							// Get today's date in the format YYYY-MM-DD
							var today = new Date();
							var formattedDate = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
							$('#empTable').DataTable({
								bJQueryUI: true,
								dom: 'Blfrtip',
								//Simple Buttons
								// buttons: [
								// 	'copy', 'csv', 'excel', 'pdf', 'print'
								// ]
								//Modify Buttons
								buttons: [
									 { extend: 'copy', text: 'Copy to Clipboard', filename: 'citizen_copy ' + formattedDate },
									 { extend: 'csv', text: 'CSV', filename: 'citizen_csv ' + formattedDate },
									{
										extend: 'excel', text: 'Export to Excel', filename: 'citizen_excel ' + formattedDate, exportOptions: {
											columns: [0, 1, 2, 3, 4, 5] // Replace with the column indices you want to export
										}
									},
									 { extend: 'pdf', text: 'PDF', filename: 'citizen_pdf ' + formattedDate },
									 { extend: 'print', text: 'Print' },
									// 'colvis'

								],
							});
						});


						//--------Print Full Page--------
						$('#sudo').click(function () {
							window.print();
							return false;
						});

					</script>
				</body>

				</html>