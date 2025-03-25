import json
import os

def split_spells_to_folders(filepath):
    """
    Splits each spell in a JSON file into its own folder and JSON file.

    Args:
        filepath (str): The path to the JSON file containing the list of spells.
    """

    try:
        print("Current working directory:", os.getcwd())
        print("Filepath provided:", filepath)

        with open(filepath, 'r', encoding='utf-8') as f:
            print("File opened successfully!")
            data = json.load(f)

        if "spells" in data and isinstance(data["spells"], list):
            spells = data["spells"]

            spells_folder = os.path.join(os.path.dirname(filepath), "spells")

            # Create the "spells" folder if it doesn't exist
            os.makedirs(spells_folder, exist_ok=True)

            for spell in spells:
                spell_name = spell.get("name", "Unnamed Spell").replace(" ", "_")
                spell_filename = f"{spell_name}.json"
                spell_filepath = os.path.join(spells_folder, spell_filename)

                # Ensure the directory for the spell file exists
                spell_dir = os.path.dirname(spell_filepath)
                if spell_dir and not os.path.exists(spell_dir):
                    os.makedirs(spell_dir, exist_ok=True)

                with open(spell_filepath, 'w', encoding='utf-8') as f:
                    json.dump(spell, f, indent=4)

            print("Spells split into individual files within the 'spells' folder successfully.")

        else:
            print("Error: JSON file does not contain a 'spells' list.")

    except json.JSONDecodeError:
        print(f"Error decoding JSON in {filepath}")
    except FileNotFoundError:
        print(f"File not found: {filepath}")
    except Exception as e:
        print(f"An error occurred processing {filepath}: {e}")

if __name__ == "__main__":
    filepath = input("Enter the path to the JSON file containing the spells: ")
    if os.path.exists(filepath) and os.path.isfile(filepath):
        split_spells_to_folders(filepath)
    else:
        print("Invalid file path.")