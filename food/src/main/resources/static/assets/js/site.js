const imageInput = document.getElementById("image-input");
const uploadedImage = document.getElementById("uploaded-image");

imageInput.addEventListener("change", function() {
  const file = this.files[0];
  const reader = new FileReader();

  reader.addEventListener("load", function() {
    uploadedImage.src = reader.result;
    uploadedImage.style.display = "block";
  });

  if (file) {
    reader.readAsDataURL(file);
  }
});
