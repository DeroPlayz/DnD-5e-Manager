import json
import os

def separate_subraces(input_dir):
    """
    Processes JSON files in a directory to separate subraces into individual files
    within folders named after the original JSON filenames.

    Args:
        input_dir (str): Path to the directory containing the JSON files.
    """

    for filename in os.listdir(input_dir):
        if filename.endswith(".json"):
            file_path = os.path.join(input_dir, filename)
            parent_dir_name = os.path.splitext(filename)[0]  # Use filename as directory name

            try:
                with open(file_path, 'r') as f:
                    data = json.load(f)

                subraces = data.pop('subraces',)  # Remove 'subraces' from parent

                # Create the parent directory if it doesn't exist
                parent_dir = os.path.join(input_dir, parent_dir_name)
                os.makedirs(parent_dir, exist_ok=True)

                # Save each subrace to its own file
                for subrace in subraces:
                    if 'name' not in subrace:
                        print(f"Warning: subrace missing 'name' in {filename}. Skipping subrace.")
                        continue
                    subrace_name = subrace['name']
                    subrace_file_path = os.path.join(parent_dir, f"{subrace_name}.json")
                    with open(subrace_file_path, 'w') as outfile:
                        json.dump(subrace, outfile, indent=4)  # Save subrace

                # Save the modified parent file (without subraces)
                with open(file_path, 'w') as outfile:
                    json.dump(data, outfile, indent=4)

                print(f"Processed: {filename}")

            except FileNotFoundError:
                print(f"Error: File not found: {file_path}")
            except json.JSONDecodeError:
                print(f"Error: Invalid JSON in {file_path}")
            except Exception as e:
                print(f"An unexpected error occurred: {e}")

def delete_empty_folders(dir_path):
    """
    Recursively deletes empty folders within a directory.

    Args:
        dir_path (str): The path to the directory to clean.
    """

    for item in os.listdir(dir_path):
        item_path = os.path.join(dir_path, item)

        if os.path.isdir(item_path):
            delete_empty_folders(item_path)  # Recursive call

            # Check if the directory is now empty
            if not os.listdir(item_path):
                print(f"Deleting empty folder: {item_path}")
                os.rmdir(item_path)



# --- Example Usage ---
input_directory = "C:/Users/matthew.ahwal/Documents/capstoneproject-e5-studios/app/src/main/assets/races"  # Replace with the path to your directory

separate_subraces(input_directory)
delete_empty_folders(input_directory)