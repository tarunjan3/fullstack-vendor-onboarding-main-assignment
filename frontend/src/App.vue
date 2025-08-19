<script setup lang="ts">
import { RouterLink } from "vue-router";
import VendorForm from "./components/VendorForm.vue";
import VendorList from "./components/VendorList.vue";
import Header from "./components/home/Header.vue";
import Footer from "./components/home/Footer.vue";
</script>

<template>
  <Header />
  <RouterView />
  <!-- <Footer /> -->
</template>
