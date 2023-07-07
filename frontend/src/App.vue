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

<style>
.btn-primary, .btn-primary:hover, .btn-primary:active, .btn-primary:visited {
    background-color: #505e86 !important;
    border: 0;
}


.btn-color, .btn-primary:hover, .btn-primary:active, .btn-primary:visited {
    background-color: #cb585d !important;
    border: 0;
}

</style>
