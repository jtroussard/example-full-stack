<script>
	import { onMount } from 'svelte';
	let choice = 0; // Default choice
	let greeting = "Loading...";
	
	async function fetchGreeting() {
	  const response = await fetch(`http://localhost:8081/api/greeting?choice=${choice}`);
	  const data = await response.json();
	  greeting = data.message;
	}
	
	onMount(fetchGreeting);
  </script>
  
  <input type="number" bind:value={choice} min="0" />
  <button on:click={fetchGreeting}>Get Greeting</button>
  <h2>{greeting}</h2>
  