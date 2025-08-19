<script setup lang="ts">
import { RouterLink } from "vue-router";
import { useRoute } from "vue-router";

const route = useRoute();
</script>

<template>
  <header class="header">
    <div class="logo">
      <span>Trusted Vendor Portal</span>
    </div>
    <nav class="nav">
      <RouterLink v-if="route.path !== '/'" to="/">Home</RouterLink>

      <!-- Disbaled below code since we already have it in landing page, will be enabled if we change the design -->

      <RouterLink
        v-if="route.path !== '/register'"
        to="/register"
        exact-active-class="active"
        >Register Vendor</RouterLink
      >
      <RouterLink
        v-if="route.path !== '/vendors'"
        to="/vendors"
        exact-active-class="active"
        >Vendor List</RouterLink
      >
    </nav>
  </header>
</template>

<style scoped>
.header {
  /* background: #000080; */
  background: #00022e;
  color: #fff;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 1rem 1.5rem;
  /* margin-bottom: 1rem; */
}

.header .logo {
  display: flex;
  align-items: center;
  gap: 0.5rem;
  font-weight: bold;
}

.header .nav {
  display: flex;
  gap: 1.5rem;
  font-size: 0.9rem;
}

.header .nav a {
  color: #fff;
  text-decoration: none;
  transition: color 0.2s ease;
}

.header .nav a:hover {
  color: #f97316; /* orange accent */
}
</style>
