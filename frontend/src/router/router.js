import { createRouter, createWebHistory } from 'vue-router'
import HomeLandingPage from '../components/home/HomeLandingPage.vue'
import RegisterVendor from '../components/vendor/VendorForm.vue'
import VendorList from '../components/vendor/VendorList.vue'

const routes = [
    { path: '/', name: 'Home', component: HomeLandingPage },
    { path: '/register', name: 'RegisterVendor', component: RegisterVendor },
    { path: '/vendors', name: 'VendorList', component: VendorList },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router