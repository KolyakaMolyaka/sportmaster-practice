<script>
import TopLogo from '@/components/TopLogo.vue';
import NavBar from '@/components/Navbar.vue';
export default {
  components: { TopLogo, NavBar }
}

</script>

<template>
  <TopLogo/>
  <NavBar/>
  <router-view></router-view>
</template>

<style scoped>

</style>
