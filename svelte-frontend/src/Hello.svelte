<script>
  import { onMount } from "svelte";
  export let message = "Loading...";

  // Fetch the message from your backend on component mount
  onMount(async () => {
    const response = await fetch("http://localhost:8081/api/hello");
    const data = await response.json();
    message = data.message;
  });
</script>

<h1>{message}</h1>
