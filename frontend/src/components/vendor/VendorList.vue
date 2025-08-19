<template>
  <div class="vendor-list">
    <h2>Vendor List</h2>
    <div v-if="vendorStore.error" class="error">
      {{ vendorStore.error }}
    </div>
    <div v-if="vendorStore.success" class="success-message">
      {{ vendorStore.success }}
    </div>
    <div v-if="vendorStore.loading">Loading vendors...</div>
    <!-- <div v-else-if="vendorStore.error" class="error">
      {{ vendorStore.error }}
    </div> -->
    <div v-else-if="vendorStore.vendors.length === 0" class="no-vendors">
      <span>No vendors found. Add your first vendor. </span>
      <span>
        <RouterLink to="/register" exact-active-class="active"
          >Register Vendor</RouterLink
        ></span
      >
    </div>
    <table v-else class="vendors-table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Contact Person</th>
          <th>Email</th>
          <th>Partner Type</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="vendor in vendorStore.vendors" :key="vendor.id">
          <td>{{ vendor.id }}</td>
          <td>{{ vendor.name }}</td>
          <td>{{ vendor.contact_person }}</td>
          <td>{{ vendor.email }}</td>
          <td>{{ vendor.partner_type }}</td>
          <td>
            <div
              v-if="vendorStore.deletingId == vendor.id && vendorStore.loading"
              :disabled="vendorStore.loading"
            >
              Deleting...
            </div>

            <button
              v-else
              class="delete-btn"
              @click="vendorStore.openDeleteDialog(vendor.id)"
            >
              Delete
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <!-- Confirmation Dialog -->
    <div v-if="vendorStore.showDialog" class="dialog-overlay">
      <div class="dialog-box">
        <h3>Are you sure?</h3>
        <p>This action will delete the vendor permanently.</p>
        <div class="actions">
          <button class="cancel" @click="vendorStore.showDialog = false">
            Cancel
          </button>
          <button class="confirm" @click="vendorStore.confirmDelete()">
            Delete
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onMounted } from "vue";
import { useVendorStore } from "../../stores/vendorStore";
import { ref } from "vue";

// Using the vendor store directly, no need for local props or state
const vendorStore = useVendorStore();

onMounted(() => {
  vendorStore.fetchVendors();
  vendorStore.error = null;
  vendorStore.success = null;
});
</script>

<style scoped>
.no-vendors span {
  padding: 1%;
}
.no-vendors span :hover {
  color: #dc2626;
}
/* dialog box css start */
.dialog-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
}

.dialog-box {
  background: white;
  padding: 20px;
  border-radius: 10px;
  width: 350px;
  text-align: center;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
}

.dialog-box h3 {
  margin-bottom: 12px;
  font-size: 18px;
  color: #1f2937;
}

.dialog-box p {
  font-size: 14px;
  color: #4b5563;
}

.dialog-box .actions {
  margin-top: 16px;
  display: flex;
  justify-content: space-around;
}

.dialog-box button {
  padding: 8px 14px;
  border-radius: 6px;
  border: none;
  cursor: pointer;
  font-weight: 500;
}

.dialog-box .confirm {
  background: #dc2626;
  color: white;
}

.dialog-box .cancel {
  background: #e5e7eb;
  color: #374151;
}
/* dialog box css ends */

.vendor-list {
  margin: auto;
  width: 98%;
}

.vendors-table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 15px;
}

.vendors-table th,
.vendors-table td {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.vendors-table th {
  background-color: #f2f2f2;
  font-weight: bold;
}

.vendors-table tr:hover {
  background-color: #f5f5f5;
}

.error {
  /* color: red;
  padding: 10px; */
  /* display: flex;
  align-items: center; */
  /* gap: 8px;
  padding: 12px 18px;
  border-radius: 8px;
  background: #fef2f2; 
  border: 1px solid #fecaca;
  color: #991b1b;  */
  /* font-size: 14px; */
  /* font-weight: 500; */
  /* max-width: 600px; */
  /* margin: 12px auto; */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);

  color: #991b1b;
  /* background-color: #d4edda; */
  background: #fef2f2;
  border: 1px solid #c3e6cb;
  padding: 10px 16px;
  border-radius: 6px;
  margin: 10px 0;
  text-align: center;
  font-weight: 500;
  max-width: 600px;
  margin-left: auto;
  margin-right: auto;
}

.success-message {
  color: #dc2626;
  background-color: #d4edda;
  border: 1px solid #c3e6cb;
  padding: 10px 16px;
  border-radius: 6px;
  margin: 10px 0;
  text-align: center;
  font-weight: 500;
  max-width: 600px;
  margin-left: auto;
  margin-right: auto;
}

.no-vendors {
  padding: 20px;
  text-align: center;
  color: #666;
}
/* delete button css */
.delete-btn {
  background-color: #f28b82; /* red color */
  color: white;
  border: none;
  padding: 8px 16px;
  border-radius: 6px;
  font-size: 14px;
  cursor: pointer;
  transition: background 0.3s ease;
}

.delete-btn:hover {
  background-color: #c62828; /* darker red on hover */
}

.delete-btn:active {
  background-color: #b71c1c; /* even darker when clicked */
}
/* delete button css ends */
</style>
