<script setup lang="ts">
import { RouterLink } from "vue-router";
import VendorForm from "./components/VendorForm.vue";
import VendorList from "./components/VendorList.vue";
</script>

<template>
  <div class="portal-container">
    <!-- Header -->
    <!-- <header class="header">
      <div class="logo">
        <span>Trusted Vendor Portal</span>
      </div>
      <nav class="nav">
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/register">Register Vendor</RouterLink>
        <RouterLink to="/vendors">Vendor List</RouterLink>
      </nav>
    </header> -->

    <!-- Hero Image -->
    <div class="hero">
      <img src="../../assets/home.jpeg" alt="Hero" />
    </div>

    <!-- Intro Text -->
    <section class="intro">
      <p>
        Welcome to the Trusted Vendor Portal – your gateway to secure and
        reliable vendor partnerships. Discover how our portal enhances vendor
        management and streamlines processes.
      </p>
    </section>

    <!-- Features -->
    <!-- <section class="features">
      <div class="feature-card">
        <span class="material-icons">settings</span>
        <h3>Efficient Vendor Management</h3>
        <button>Learn More</button>
      </div>
      <div class="feature-card">
        <span class="material-icons">lock</span>
        <h3>Secure Transactions</h3>
        <button>Learn More</button>
      </div>
    </section> -->

    <!-- Call To Action -->
    <section class="cta">
      <!-- <button class="v-primary">Register a New Vendor</button> -->
      <RouterLink to="/register" exact-active-class="active" class="v-primary"
        >Register Vendor</RouterLink
      >
      <!-- <button class="secondary">View Registered Vendors</button> -->
      <RouterLink to="/vendors" exact-active-class="active" class="v-primary"
        >Vendor List</RouterLink
      >
    </section>

    <!-- Footer -->
    <footer class="footer">
      <p>Contact us: trustedvendor@maersk.com</p>
    </footer>
  </div>
</template>

<style scoped>
.portal-container {
  min-height: 92vh;
  display: flex;
  flex-direction: column;
  background: #ffffff;
  color: #111;
  font-family: Arial, sans-serif;
}

.hero {
  /* width: 100%;
  height: 190px;
  background: #f3f4f6;
  display: flex;
  align-items: center;
  justify-content: center; */
  height: 150px;
  background: #f3f4f6;
  /* display: flex
; */
  /* align-items: center; */
  justify-content: center;
  padding: 10px;
}

.hero img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.intro {
  text-align: center;
  max-width: 750px;
  margin: 2.5rem auto;
  padding: 0 1rem;
  font-size: 1.1rem;
  line-height: 1.6;
  color: #333;
}

.features {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 1.5rem;
  max-width: 800px;
  margin: 0 auto;
  padding: 0 1.5rem;
}

.feature-card {
  background: #e5e7eb;
  border-radius: 8px;
  padding: 2rem;
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  transition: transform 0.2s ease;
}

.feature-card:hover {
  transform: translateY(-3px);
}

.feature-card h3 {
  margin: 0.5rem 0;
  font-size: 1rem;
  font-weight: 600;
}

.feature-card button {
  margin-top: 0.75rem;
  background: #d1d5db;
  border: none;
  border-radius: 6px;
  padding: 0.5rem 1.25rem;
  cursor: pointer;
  transition: background 0.2s ease;
}

.feature-card button:hover {
  background: #9ca3af;
  color: #fff;
}

.cta {
  display: flex;
  justify-content: center;
  gap: 1.5rem;
  padding: 2rem 0;
}

.cta .v-primary {
  background: #00022e;
  color: #fff;
  border: none;
  padding: 0.75rem 1.5rem;
  border-radius: 6px;
  cursor: pointer;
  text-decoration: none;
  transition: background 0.2s ease;
}

.cta .v-primary:hover {
  background: #f97316;
}

.cta .secondary {
  border: 1px solid #000;
  background: #fff;
  padding: 0.75rem 1.5rem;
  border-radius: 6px;
  cursor: pointer;
  transition: background 0.2s ease;
}

.cta .secondary:hover {
  background: #f3f4f6;
}

.footer {
  /* background: #000;
  color: #fff;
  padding: 1.5rem;
  margin-top: auto;
  font-size: 0.9rem; */
  background: #000;
  color: #fff;
  padding: 0.5rem;
  margin-top: auto;
  font-size: 0.9rem;
}

.footer .socials {
  display: flex;
  gap: 1rem;
  margin-top: 0.5rem;
}

.footer .socials a {
  color: #fff;
  transition: color 0.2s ease;
}

.footer .socials a:hover {
  color: #f97316;
}
</style>
