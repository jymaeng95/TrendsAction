<template>
<div class="header-area">
  <video class="embed-container" id="videoBG" autoplay muted loop>
    <source src="@/assets/video/ink.mp4" type="video/mp4">
  </video>
  <div class="content" 
      data-sal="slide-up"
      data-sal-duration="800"
      data-sal-repeat
      >
      
      <h2>Trends Action</h2>
      <span>트렌드를 액션하라!</span>
      <p></p>
    </div>
    <div class="arrow" @click="$vuetify.goTo('#first-section')"><span style="color:white; font-size: 3rem"><i class="fas fa-arrow-down"></i></span></div>
  <!-- <div class="header-area">
    <img class="header-img" src="https://source.unsplash.com/random" alt="header-image">
    <div class="content" 
      data-sal="slide-up"
      data-sal-duration="800"
      data-sal-repeat
      >
      <h2>Trends Action!</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Deleniti, quod blanditiis sequi dolor eveniet minus adipisci? Corporis itaque accusamus, facere magni distinctio et repellendus non deleniti, voluptas, quam sapiente expedita.</p>
    </div>
    <div class="arrow" @click="$vuetify.goTo('#first-section')"><span style="color:white; font-size: 3rem"><i class="fas fa-arrow-down"></i></span></div>
  </div> -->
</div>
</template>

<script>
import sal from "sal.js";
export default {
  name: 'Header',
  mounted() {
    sal();
  }
}
</script>

<style>
#videoBG {
  object-fit: cover;
  width: 100vw;
  height: 100vh;
  position: absolute;
  top: 0;
  left: 0;
}

.header-area {
  position: relative;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.header-area img {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.header-area .content {
  position: relative;
  text-align: center;
  max-width: 750px;
  color: white;
}

.header-area .content h2 {
  font-size: 60px;
}

.header-area .content p {
  font-size: 18px;
}
.header-area .arrow {
  position: absolute;
  bottom: 30px;
  left: 0;
  right: 0;
  text-align: center;
  cursor: pointer;
}
</style>