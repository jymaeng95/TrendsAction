<template>
  <v-app>
    <div>
      <!-- <Navbar /> -->
    </div>
    <v-main class="main-area">
      <router-view></router-view>
    </v-main>
    <Footer />
  </v-app>
</template>

<script>
// import Navbar from '@/components/common/Navbar2'
import Footer from '@/components/common/Footer'

export default {
  name: 'App',
  components: {
    // Navbar,
    Footer
  },
  data: () => ({
    //
  }),
};
</script>

<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700;900&display=swap');

#app {
  background: #F5F5F6;
  font-family: 'Noto Sans KR', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
