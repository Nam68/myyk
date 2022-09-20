<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <div class="col-md-6 d-flex align-items-center">
      <a href="/" class="mb-3 me-2 mb-md-0 text-decoration-none lh-1 primary-dark-color">
        <svg class="bi"><use xlink:href="#bootstrap"/></svg>
      </a>
      <span class="primary-dark-color-not-hover pe-none">&copy; 2022 Company, Inc</span>
    </div>

    <ul class="nav col-md-6 justify-content-end list-unstyled d-flex">
      <li class="ms-3"><a class="text-muted primary-dark-color" href="#"><svg class="bi" width="24" height="24" fill="currentColor"><use xlink:href="#twitter"/></svg></a></li>
      <li class="ms-3"><a class="primary-dark-color" href="#"><svg class="bi" width="24" height="24" fill="currentColor"><use xlink:href="#instagram"/></svg></a></li>
      <li class="ms-3"><a class="text-muted primary-dark-color" href="#"><svg class="bi" width="24" height="24" fill="currentColor"><use xlink:href="#facebook"/></svg></a></li>
    </ul>
  </footer>
  
  <!-- 로딩 모달 -->
  <div class="loading-spinner">
  	<div class="spinner-border text-info" style="width: 3rem; height: 3rem;" role="status">
	  <span class="visually-hidden">Loading...</span>
	</div>
  </div>
  <button id="loading-modal-btn" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#loading-modal">
    Launch static backdrop modal
  </button>
  <!-- Modal -->
  <div class="modal" id="loading-modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
  </div>
  
  
<script>
function openLoading() {
	$('#loading-modal-btn').trigger('click');
	$('.loading-spinner').css('display', 'flex');
}

function closeLoading() {
	$('#loading-modal-btn').trigger('click');
	$('.loading-spinner').css('display', 'none');
}
</script>
