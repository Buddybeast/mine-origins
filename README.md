# Mine Origins (Minecraft 26.2 - Fabric)

**Mine Origins** is a rich, modern exploration and metallurgy mod for Minecraft 26.2 running on Fabric. It introduces realistic ore processing suites (Aluminium and Titanium), a tropical coconut palm ecosystem with functional ropes, wildlife such as high-altitude hunting Eagles, and a floating celestial dimension — the **Aetherial Aurora**.

---

## 🌟 Mod Features Overview

- **Metallurgy & Ores**:
  - **Bauxite & Aluminium Suite**: Natural Bauxite deposits, raw bauxite chunks, smelted aluminium ingots, and storage blocks.
  - **Ilmenite, Rutile & Titanium Suite**: Deepslate Ilmenite and high-tier Rutile ores, raw titanium, titanium ingots, and reinforced blocks.
  - **Sky Metal & Chroma Ore**: Extraterrestrial materials discovered on floating islands.
- **Tropical Coconut Trees**:
  - Naturally spawning along beaches and coasts with realistic curving trunks and swollen bases.
  - 3-stage coconut sapling growth supportable with bone meal.
  - Harvesting coconut logs yields coconut fibers, craftable into versatile **Rope**.
  - Punching or harvesting yields fresh **Coconuts**.
- **Fauna & Wildlife**:
  - **Eagle Mob**: High-altitude raptor soaring 25–40 blocks above ground that swoops down at high speed to hunt small prey (rabbits, chickens, and frogs).
  - Can be spawned via the **Eagle Spawn Egg** or naturally found around mountain peaks and ocean shores.
- **The Sky Dimension: Aetherial Aurora**:
  - A low-gravity dimension featuring floating islands surrounded by boundless open sky.
  - Unique glowing flora and blocks: **Sky Stone**, **Sky Grass**, **Glimmerstone** (Light Level 15), **Prism Wood**, and **Prism Leaves**.
  - Accessible via the **Aetherial Key** and **Aetherial Portal**.
  - Magical artifacts: **Dreamcatcher Wand** providing slow falling and levitation propulsion.

---

## 🛠️ Metallurgy & Processing Recipes

### 1. Aluminium Suite
| Source Material | Process | Output |
|---|---|---|
| `mine-origins:bauxite_ore` | Furnace / Blast Furnace | `mine-origins:aluminium` (Ingot) |
| `mine-origins:raw_bauxite` | Furnace / Blast Furnace | `mine-origins:aluminium` (Ingot) |
| `mine-origins:bauxite` (Chunk) | Furnace / Blast Furnace | `mine-origins:aluminium` (Ingot) |
| 9x `mine-origins:aluminium` | Crafting Table (3x3) | `mine-origins:aluminium_block` |
| `mine-origins:aluminium_block` | Crafting Table (1x1) | 9x `mine-origins:aluminium` |

### 2. Titanium Suite
| Source Material | Process | Output |
|---|---|---|
| `mine-origins:ilmenite_ore` | Furnace / Blast Furnace | `mine-origins:titanium` (Ingot) |
| `mine-origins:rutile_ore` | Furnace / Blast Furnace | `mine-origins:titanium` (Ingot) |
| `mine-origins:raw_titanium` | Furnace / Blast Furnace | `mine-origins:titanium` (Ingot) |
| `mine-origins:ilmenite` / `rutile` (Chunks) | Furnace / Blast Furnace | `mine-origins:titanium` (Ingot) |
| 9x `mine-origins:titanium` | Crafting Table (3x3) | `mine-origins:titanium_block` |
| `mine-origins:titanium_block` | Crafting Table (1x1) | 9x `mine-origins:titanium` |

---

## 🌴 Coconut Palm Ecosystem

- **Spawning**: Spawns automatically on beaches, coasts, and warm ocean shorelines.
- **Fiber to Rope**:
  - `9x Coconut Fiber` (obtained from logs / foliage) ➔ `mine-origins:rope`.
- **Fuel & Smelting**:
  - `mine-origins:coconut_log` ➔ `minecraft:charcoal` (in furnace).
  - `mine-origins:coconut_wood` ➔ `minecraft:charcoal` (in furnace).
- **Growth**:
  - Plant `Coconut Sprout` on sand, dirt, or grass. Apply bone meal to progress through sprout stages into a towering coconut palm.

---

## 🦅 Wildlife: Eagle

- **Behavior**:
  - Circles lazily high above mountains and coastal plains.
  - Automatically identifies rabbits, frogs, and chickens on the ground.
  - Performs rapid swoop dives to strike targets before gliding back up into orbit.
- **Breeding & Feeding**:
  - Attracted to and bred with raw chicken or rabbit.

---

## 🌌 The Sky Dimension — "Aetherial Aurora"

### Accessing the Dimension
1. Craft an **Aetherial Key** using:
   - `1x Chromatic Gem` + `2x Sky Metal Ingots`.
2. Right-click any **Quartz Block** or **Glimmerstone** with the Aetherial Key to open an **Aetherial Portal**.
3. Step inside to ascend to the floating islands. A safe landing platform is automatically generated.

### Sky Resources & Tools
- **Glimmerstone**: Naturally illuminated crystal providing maximum illumination (light level 15).
- **Prism Wood**: Ethereal purple and magenta timber craftable into **Prism Planks**.
- **Dreamcatcher Wand**:
  - Crafted with: `1x Chromatic Gem`, `1x Glimmerstone`, `1x Rope`, and `2x Sky Metal Ingots`.
  - Right-click to trigger a burst of levitation, health regeneration, and slow-falling aura.

---

## 🐉 The Dragon City Dimension — Megastructure of Draconium

Inspired by the animated universe of *Dragon Booster*, **Dragon City** is a vertically stratified megastructure extending across expanded world heights (`Y = -64` to `Y = 320+`). Built upon ancient subterranean ruins and rising into aerodynamic spires, the dimension features layered horizontal shelves interconnected by suspended raceways, mega-pylons, and Draconium energy conduits.

### 🏙️ Vertical Tiers & Strata
1. **Sun City (Y = 256 to 384)**:
   - **Theme**: Aerodynamic spires, pristine racing loops, open skies.
   - **Palette**: Smooth Quartz, White & Cyan Concrete, Sea Lanterns, Light Blue Glass, Iron Blocks.
2. **Mid City & Work Town (Y = 128 to 255)**:
   - **Theme**: Dense industrial urban high-rises, garages, refineries, and mag-rails.
   - **Palette**: Stone Bricks, Smooth Stone, Polished Andesite, Copper, Redstone conduits, Iron Bars.
3. **Down City & Shadowtown (Y = 0 to 127)**:
   - **Theme**: The underbelly beneath the mega-foundations, perpetual gloom, steam conduits, neon graffiti.
   - **Palette**: Weathered Copper, Deepslate, Shroomlights, Chains, Exposed Grates.
4. **Old City & The Chasm (Y = -64 to -1)**:
   - **Theme**: Ancient buried ruins, subterranean bone yards, raw draconium fissures.
   - **Palette**: Polished Blackstone, Basalt, Bone Blocks, Sculk, Soul Sand.

### ⚡ Mechanics: Draconium Mag-Boost Pads
- **High-Velocity Raceways**: Integrated racing tracks throughout the dimension feature **Draconium Mag-Boost Pads**.
- **Physics**: Sprinting or running across these pads applies high slipperiness (`friction: 0.98`), a burst of **Speed IV**, and an immediate forward velocity surge along your facing direction.

### 🚪 How to Enter Dragon City
1. **Craft a Draconium Core**:
   - Combine `4x Gold Ingots`, `4x Polished Blackstone`, and `1x Ender Pearl` on a Crafting Table.
     ```
     [ Gold Ingot ] [ Polished Blackstone ] [ Gold Ingot ]
     [ Polished Blackstone ] [ Ender Pearl ] [ Polished Blackstone ]
     [ Gold Ingot ] [ Polished Blackstone ] [ Gold Ingot ]
     ```
2. **Open the Portal**:
   - Place down **Smooth Stone**.
   - Right-click the **Smooth Stone** with the **Draconium Core**.
   - An ethereal **golden-black void portal** will erupt with electric sparks and dark smoke particles.
3. **Teleportation**:
   - Step into the portal to arrive directly at the suspended **Mid City Tier** (`Y = 200`), landing on a reinforced Smooth Stone and Polished Blackstone arrival platform with a return portal to the Overworld.

---

## 📦 Building and Running

### Requirements
- **Java 25** (JDK 25)
- **Minecraft 26.2**
- **Fabric Loader >= 0.19.5**

### Commands
- **Compile & Validate**:
  ```bash
  ./gradlew compileJava compileClientJava
  ```
- **Build Production Mod Jar**:
  ```bash
  ./gradlew build
  ```
- **Launch Minecraft Client**:
  ```bash
  ./gradlew runClient
  ```
