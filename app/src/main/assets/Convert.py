import os
import json

def convert_cah_to_json(directory):
    """
    Converts all .cah files to .json files within a directory and its subfolders.
    Renames folders with identical names to files by appending "subraces".

    Args:
        directory (str): The path to the directory to scan.
    """
    for root, dirs, files in os.walk(directory):
        for filename in files:
            if filename.endswith(".cah"):
                cah_filepath = os.path.join(root, filename)
                json_filepath = os.path.splitext(cah_filepath)[0] + ".json"

                # Check for folder with the same name (same base name as the .cah file)
                folder_name = os.path.splitext(filename)[0]  # This extracts the file name without extension
                folder_path = os.path.join(root, folder_name)

                if os.path.exists(folder_path) and os.path.isdir(folder_path):
                    print(f"There is a folder with the same name as a file: {folder_path}")
                    new_folder_path = folder_path + "subraces"
                    if not os.path.exists(new_folder_path):  # Prevents overwriting
                        os.rename(folder_path, new_folder_path)
                        print(f"Renamed folder: {folder_path} -> {new_folder_path}")
                    else:
                        print(f"Folder {new_folder_path} already exists. Skipping renaming.")

                try:
                    with open(cah_filepath, 'r') as cah_file:
                        data = json.load(cah_file)

                    with open(json_filepath, 'w') as json_file:
                        json.dump(data, json_file, indent=4)

                    os.remove(cah_filepath)

                    print(f"Converted: {cah_filepath} -> {json_filepath}")

                except json.JSONDecodeError:
                    print(f"Error: {cah_filepath} is not valid JSON. Skipping.")
                except Exception as e:
                    print(f"Error processing {cah_filepath}: {e}")

if __name__ == "__main__":
    # directory_to_scan = "C:/Users/matthew.ahwal/Documents/capstoneproject-e5-studios/app/src/main/assets"
    directory_to_scan = "/workspaces/capstoneproject-e5-studios/app/src/main/assets/races"
    if os.path.exists(directory_to_scan):
        convert_cah_to_json(directory_to_scan)
    else:
        print(f"Error: Directory '{directory_to_scan}' not found.")
