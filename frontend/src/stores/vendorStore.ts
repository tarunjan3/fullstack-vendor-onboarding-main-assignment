import { defineStore } from "pinia";
import { ref } from "vue";
import { VendorService } from "../services/VendorService";
import type { Vendor } from "../types/Vendor";

export const useVendorStore = defineStore("vendor", () => {
  const vendors = ref<Vendor[]>([]);
  const loading = ref(false);
  const error = ref<string | null>(null);
  const success = ref<string | null>(null);
  // Vendor id maintained to show spinner on individual record delete
  const vendorIdToDelete = ref<number | null>(null);
  const showDialog = ref(false);

  async function fetchVendors() {
    loading.value = true;
    error.value = null;

    try {
      vendors.value = (await VendorService.getVendors()).reverse();
    } catch (err) {
      error.value = "Failed to load vendors. Please try again later.";
      console.error(err);
    } finally {
      loading.value = false;
    }
  }

  async function addVendor(vendor: Vendor) {
    // No need to maintain the loading from store, handled from the local sucess state in VendorForm component

    // loading.value = true;
    error.value = null;

    try {
      await VendorService.createVendor(vendor);
      // Refresh the vendors list after adding a new vendor
      await fetchVendors();
    } catch (err) {
      if (err.includes("email")) {
        error.value = err;
      } else {
        error.value = "Failed to add vendor. Please try again later.";
      }

      console.error(err);
      throw err;
    } finally {
      // loading.value = false;
    }
  }

  async function confirmDelete() {
    if (this.vendorIdToDelete !== null) {
      await this.deleteVendor(this.vendorIdToDelete);
    }
    this.closeDeleteDialog(); // always close
  }

  function openDeleteDialog(id: number) {
    this.vendorIdToDelete = id;
    this.showDialog = true;
  }

  function closeDeleteDialog() {
    this.showDialog = false;
    this.vendorIdToDelete = null;
  }

  async function deleteVendor(id: string) {
    loading.value = true;
    error.value = null;
    success.value = null;
    try {
      const message = await VendorService.deleteVendor(id);
      success.value = message;
      // Refresh the vendors list after deleting a vendor
      await fetchVendors();
    } catch (err) {
      error.value = err.message;
      console.error(err);
      throw err;
    } finally {
      this.showDialog = false;
      loading.value = false;
    }
  }

  return {
    vendors,
    loading,
    error,
    success,
    showDialog,
    vendorIdToDelete,
    confirmDelete,
    openDeleteDialog,
    closeDeleteDialog,
    fetchVendors,
    addVendor,
    deleteVendor,
  };
});
