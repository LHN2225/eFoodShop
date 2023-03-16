const imageInput = document.getElementById("image-input");
const uploadedImage = document.getElementById("uploaded-image");
const isImageChangeInput = document.getElementById("isImageChange");


imageInput.addEventListener("change", function() {
  const file = this.files[0];
  const reader = new FileReader();

  reader.addEventListener("load", function() {
    uploadedImage.src = reader.result;
    uploadedImage.style.display = "block";
    isImageChangeInput.value = "true";
  });

  if (file) {
    reader.readAsDataURL(file);
  }
});
